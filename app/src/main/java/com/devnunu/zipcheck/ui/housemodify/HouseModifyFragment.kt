package com.devnunu.zipcheck.ui.housemodify

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.databinding.FragmentHouseModifyBinding

class HouseModifyFragment : BaseFragmentKoin<FragmentHouseModifyBinding, HouseModifyViewModel>(
    R.layout.fragment_house_modify,
    HouseModifyViewModel::class.java
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }
        }
    }
}