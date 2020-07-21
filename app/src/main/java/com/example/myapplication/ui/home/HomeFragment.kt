package com.example.myapplication.ui.home

import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.common.BaseFragment
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun setBindingVariables() {
        super.setBindingVariables()
    }
}