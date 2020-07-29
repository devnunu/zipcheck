package com.devnunu.zipcheck.ui.home

import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHomeBinding
import com.devnunu.zipcheck.ui.home.item.HouseItemAdapter
import com.devnunu.zipcheck.ui.home.item.HouseItemListener

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.listHouse.adapter = HouseItemAdapter(object : HouseItemListener {
                override fun onClickHouseItem(id: String) {
                    val action = HomeFragmentDirections.actionHomeFragmentToHouseDetailFragment()
                    findNavController().navigate(action)
                }
            })
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddHouseBtn.observe(this, EventObserver {
            val action = HomeFragmentDirections.actionHomeFragmentToInputHouseFragment()
            findNavController().navigate(action)
        })
    }
}

