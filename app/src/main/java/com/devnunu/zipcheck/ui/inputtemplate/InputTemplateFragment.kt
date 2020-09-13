package com.devnunu.zipcheck.ui.inputtemplate

import android.view.View
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentInputTemplateBinding
import com.devnunu.zipcheck.ui.inputtemplate.item.TemplateItemAdapter

class InputTemplateFragment : BaseFragmentKoin<FragmentInputTemplateBinding, InputTemplateViewModel>(
    R.layout.fragment_input_template,
    InputTemplateViewModel::class.java
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().navigateUp() }
            it.listChecklistTemplate.adapter = TemplateItemAdapter(viewModel)
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddTemplateBtn.observe(this, EventObserver {
            val action =
                InputTemplateFragmentDirections.actionInputCheckListFragmentToInputListNameFragment()
            findNavController().navigate(action)
        })

        viewModel.onSuccessSubmitHouse.observe(this, EventObserver {
//            val action =
//                InputCheckListFragmentDirections.actionInputCheckListFragmentToHomeFragment()
//            findNavController().navigate(action)
        })
    }
}