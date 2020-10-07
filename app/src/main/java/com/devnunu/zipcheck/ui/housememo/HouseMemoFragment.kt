package com.devnunu.zipcheck.ui.housememo

import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.databinding.FragmentHouseMemoBinding

class HouseMemoFragment : BaseFragmentKoin<FragmentHouseMemoBinding, HouseMemoViewModel>(
    R.layout.fragment_house_memo,
    HouseMemoViewModel::class.java
) {

    override fun setBindingVariables() {
        super.setBindingVariables()
        binding.also {
            it.viewModel = viewModel
        }
    }
}