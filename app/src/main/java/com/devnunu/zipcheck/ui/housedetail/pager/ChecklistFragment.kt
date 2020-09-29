package com.devnunu.zipcheck.ui.housedetail.pager

import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.databinding.FragmentHouseDetailChecklistBinding
import com.devnunu.zipcheck.ui.housedetail.HouseDetailViewModel
import com.devnunu.zipcheck.ui.housedetail.item.ChecklistItemAdapter

class ChecklistFragment :
    BaseFragmentKoin<FragmentHouseDetailChecklistBinding, HouseDetailViewModel>(
        R.layout.fragment_house_detail_checklist,
        HouseDetailViewModel::class.java
    ) {

    override fun setBindingVariables() {
        super.setBindingVariables()
        binding.also {
            it.listCheckItem.adapter = ChecklistItemAdapter(viewModel)
            it.viewModel = viewModel
        }
    }

    companion object {
        fun newInstance(): ChecklistFragment {
            return ChecklistFragment()
        }
    }
}