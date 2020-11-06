package com.devnunu.zipcheck.ui.housedetail.pager

import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHouseDetailInfoBinding
import com.devnunu.zipcheck.ui.housedetail.HouseDetailFragmentDirections
import com.devnunu.zipcheck.ui.housedetail.HouseDetailViewModel

class InfoFragment : BaseFragmentKoin<FragmentHouseDetailInfoBinding, HouseDetailViewModel>(
    R.layout.fragment_house_detail_info,
    HouseDetailViewModel::class.java
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
        }
    }

    override fun setEventObservers() {
        viewModel.onClickEditBtn.observe(this, EventObserver { id ->
            val action =
                HouseDetailFragmentDirections.actionHouseDetailFragmentToHouseModifyFragment(id)
            findNavController().navigate(action)
        })
    }

    companion object {
        fun newInstance(): InfoFragment {
            return InfoFragment()
        }
    }
}