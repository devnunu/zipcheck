package com.devnunu.zipcheck.ui.housedetail

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHouseDetailBinding
import com.devnunu.zipcheck.ui.housedetail.dialog.RatingDialog
import com.devnunu.zipcheck.ui.housedetail.item.ChecklistItemListener
import com.devnunu.zipcheck.ui.housedetail.pager.HouseDetailPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HouseDetailFragment : BaseFragmentKoin<FragmentHouseDetailBinding, HouseDetailViewModel>(
    R.layout.fragment_house_detail,
    HouseDetailViewModel::class.java
) {

    private val textArray = arrayOf("체크리스트", "메모")
    private val arg: HouseDetailFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setViewPagerAdapter()
        start()
    }

    private fun start() {
        arg.houseId.let {
            viewModel.start(it)
        }
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }
        }
    }

    override fun setEventObservers() {
        viewModel.onClickDeleteBtn.observe(this, EventObserver {
            showDeleteConfirmDialog()
        })

        viewModel.onSuccessDeleteHouse.observe(this, EventObserver {
            showToast("집 정보가 삭제 되었습니다.")
            findNavController().popBackStack()
        })
    }

    private fun showDeleteConfirmDialog() {
        AlertDialog.Builder(requireContext())
            .setMessage("정말 삭제하시겠습니까?")
            .setCancelable(true)
            .setNegativeButton("아니요", null)
            .setPositiveButton("네") { _, _ ->
                viewModel.deleteHouse()
            }.create()
            .show()
    }

    private fun setViewPagerAdapter() {
        val adapter = HouseDetailPagerAdapter(requireActivity())
        binding.apply {
            viewpager.adapter = adapter
            TabLayoutMediator(layoutTab, viewpager) { tab, position ->
                tab.text = textArray[position]
            }.attach()
            viewpager.isSaveEnabled = false
        }
    }
}