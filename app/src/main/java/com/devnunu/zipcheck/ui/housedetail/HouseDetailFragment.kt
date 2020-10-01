package com.devnunu.zipcheck.ui.housedetail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
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