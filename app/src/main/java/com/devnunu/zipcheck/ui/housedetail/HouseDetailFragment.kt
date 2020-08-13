package com.devnunu.zipcheck.ui.housedetail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHomeBinding
import com.devnunu.zipcheck.databinding.FragmentHouseDetailBinding
import com.devnunu.zipcheck.ui.housedetail.category.HouseChecklistCategoryItemAdapter
import com.devnunu.zipcheck.ui.inputtemplate.category.InputChecklistCategoryItemAdapter

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
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }
            it.listCategoryName.adapter =
                HouseChecklistCategoryItemAdapter(viewModel)
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddChecklistBtn.observe(this, EventObserver {
            val action =
                HouseDetailFragmentDirections.actionHouseDetailFragmentToInputCheckListFragment()
            findNavController().navigate(action)
        })
    }
}