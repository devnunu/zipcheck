package com.devnunu.zipcheck.ui.inputtemplate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentInputTemplateBinding
import com.devnunu.zipcheck.ui.housedetail.HouseDetailFragmentArgs
import com.devnunu.zipcheck.ui.inputtemplate.item.TemplateItemAdapter
import com.devnunu.zipcheck.ui.inputtemplateitem.InputTemplateItemFragmentArgs

class InputTemplateFragment :
    BaseFragmentKoin<FragmentInputTemplateBinding, InputTemplateViewModel>(
        R.layout.fragment_input_template,
        InputTemplateViewModel::class.java
    ) {

    private val arg: InputTemplateFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arg.houseId?.let {
            viewModel.houseId.value = it
        }
    }

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
            findNavController().popBackStack()
        })
    }
}