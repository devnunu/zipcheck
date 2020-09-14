package com.devnunu.zipcheck.ui.housedetail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHouseDetailBinding
import com.devnunu.zipcheck.ui.housedetail.item.ChecklistItemAdapter

class HouseDetailFragment : BaseFragmentKoin<FragmentHouseDetailBinding, HouseDetailViewModel>(
    R.layout.fragment_house_detail,
    HouseDetailViewModel::class.java
) {
    private val arg: HouseDetailFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arg.houseId?.let {
            viewModel.start(it)
        }
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.listCheckItem.adapter = ChecklistItemAdapter(viewModel)
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddChecklistBtn.observe(this, EventObserver {
            val action =
                HouseDetailFragmentDirections.actionHouseDetailFragmentToInputCheckListFragment(it)
            findNavController().navigate(action)
        })
    }
}