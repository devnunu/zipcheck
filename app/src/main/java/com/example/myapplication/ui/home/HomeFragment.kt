package com.example.myapplication.ui.home

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.common.BaseFragment
import com.example.myapplication.common.EventObserver
import com.example.myapplication.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_input_house.*

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

