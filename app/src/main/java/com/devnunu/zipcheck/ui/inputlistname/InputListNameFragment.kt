package com.devnunu.zipcheck.ui.inputlistname

import android.view.View
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentInputChecklistNameBinding

class InputListNameFragment :
    BaseFragment<FragmentInputChecklistNameBinding, InputListNameViewModel>(
        R.layout.fragment_input_checklist_name,
        InputListNameViewModel::class
    ) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }
        }
    }

    override fun setEventObservers() {
        viewModel.onClickNextBtn.observe(this, EventObserver { name ->
            val action =
                InputListNameFragmentDirections.actionInputListNameFragmentToCheckListTemplateFragment(
                    name!!
                )
            findNavController().navigate(action)
        })
    }
}