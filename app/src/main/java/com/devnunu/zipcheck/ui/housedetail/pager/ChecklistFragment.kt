package com.devnunu.zipcheck.ui.housedetail.pager

import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.databinding.FragmentHouseDetailChecklistBinding
import com.devnunu.zipcheck.ui.housedetail.HouseDetailViewModel
import com.devnunu.zipcheck.ui.housedetail.dialog.RatingDialog
import com.devnunu.zipcheck.ui.housedetail.item.ChecklistItemAdapter
import com.devnunu.zipcheck.ui.housedetail.item.ChecklistItemListener

class ChecklistFragment :
    BaseFragmentKoin<FragmentHouseDetailChecklistBinding, HouseDetailViewModel>(
        R.layout.fragment_house_detail_checklist,
        HouseDetailViewModel::class.java
    ), ChecklistItemListener {

    override fun setBindingVariables() {
        super.setBindingVariables()
        binding.also {
            it.listCheckItem.adapter = ChecklistItemAdapter(this)
            it.viewModel = viewModel
        }
    }

    override fun onClickCheck(index: Int, point: Int) {
        val dialog = RatingDialog(index, point, viewModel)
        dialog.show(parentFragmentManager, dialog.tag)
    }

    companion object {
        fun newInstance(): ChecklistFragment {
            return ChecklistFragment()
        }
    }
}