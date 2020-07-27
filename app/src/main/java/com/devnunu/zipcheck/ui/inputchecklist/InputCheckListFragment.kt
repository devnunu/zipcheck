package com.devnunu.zipcheck.ui.inputchecklist

import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHouseDetailBinding
import com.devnunu.zipcheck.databinding.FragmentInputChecklistBinding

class InputCheckListFragment : BaseFragment<FragmentInputChecklistBinding, InputCheckListViewModel>(
    R.layout.fragment_input_checklist,
    InputCheckListViewModel::class
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddTemplateBtn.observe(this, EventObserver {
            val action =
                InputCheckListFragmentDirections.actionInputCheckListFragmentToCheckListTemplateFragment()
            findNavController().navigate(action)
        })
    }
}