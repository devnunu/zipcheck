package com.devnunu.zipcheck.ui.houseedit

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.databinding.FragmentHouseEditBinding

class HouseEditFragment : BaseFragmentKoin<FragmentHouseEditBinding, HouseEditViewModel>(
    R.layout.fragment_house_edit,
    HouseEditViewModel::class.java
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