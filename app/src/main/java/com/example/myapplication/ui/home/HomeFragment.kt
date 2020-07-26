package com.example.myapplication.ui.home

import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.common.BaseFragment
import com.example.myapplication.common.EventObserver
import com.example.myapplication.databinding.FragmentHomeBinding

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

