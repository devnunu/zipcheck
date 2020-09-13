package com.devnunu.zipcheck.ui.inputtemplatename

import android.view.View
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentInputTemplateNameBinding

class InputTemplateNameFragment :
    BaseFragmentKoin<FragmentInputTemplateNameBinding, InputTemplateNameViewModel>(
        R.layout.fragment_input_template_name,
        InputTemplateNameViewModel::class.java
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
                InputTemplateNameFragmentDirections.actionInputListNameFragmentToCheckListTemplateFragment(
                    name!!
                )
            findNavController().navigate(action)
        })
    }
}