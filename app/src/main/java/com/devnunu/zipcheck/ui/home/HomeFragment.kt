package com.devnunu.zipcheck.ui.home

import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddHouseBtn.observe(this, EventObserver {
            val action = HomeFragmentDirections.actionHomeFragmentToInputHouseFragment()
            findNavController().navigate(action)
        })
    }
}

