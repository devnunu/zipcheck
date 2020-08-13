package com.devnunu.zipcheck.ui.inputtemplateitem

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.data.template.model.ChecklistType
import com.devnunu.zipcheck.databinding.FragmentInputTemplateItemBinding
import com.devnunu.zipcheck.ui.inputtemplateitem.category.InputChecklistCategoryItemAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class InputTemplateItemFragment :
    BaseFragment<FragmentInputTemplateItemBinding, InputTemplateItemViewModel>(
        R.layout.fragment_input_template_item,
        InputTemplateItemViewModel::class
    ) {

    private val arg: InputTemplateItemFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setArgument(arg.checklistName)
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }
        }
    }

    override fun setEventObservers() {
        viewModel.onSuccessSaveTemplate.observe(this, EventObserver {
            val action =
                InputTemplateItemFragmentDirections.actionCheckListTemplateFragmentToInputCheckListFragment()
            findNavController().navigate(action)
        })
    }
}