package com.devnunu.zipcheck.ui.housedetail

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.databinding.FragmentHomeBinding
import com.devnunu.zipcheck.databinding.FragmentHouseDetailBinding

class HouseDetailFragment : BaseFragment<FragmentHouseDetailBinding, HouseDetailViewModel>(
    R.layout.fragment_house_detail,
    HouseDetailViewModel::class
) {
    private val arg: HouseDetailFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.start(arg.houseId)
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
        }
    }

}