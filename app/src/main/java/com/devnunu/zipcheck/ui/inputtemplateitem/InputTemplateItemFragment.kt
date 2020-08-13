package com.devnunu.zipcheck.ui.inputtemplateitem

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.common.util.StyleUtil
import com.devnunu.zipcheck.databinding.FragmentInputTemplateItemBinding
import com.devnunu.zipcheck.ui.inputtemplateitem.category.InputTemplateItemAdapter


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
            it.listItem.adapter = InputTemplateItemAdapter(viewModel)
            it.listItem.addItemDecoration(StyleUtil.getDividerItemDecoration(R.drawable.divider_mono200))
            it.listItem.itemAnimator = DefaultItemAnimator()
        }
    }

    override fun setEventObservers() {
        viewModel.onSuccessSaveTemplate.observe(this, EventObserver {
            val action =
                InputTemplateItemFragmentDirections.actionCheckListTemplateFragmentToInputCheckListFragment()
            findNavController().navigate(action)
        })

        viewModel.onClickAddItem.observe(this, EventObserver { checkItem ->
            val adapter = binding.listItem.adapter as InputTemplateItemAdapter
            adapter.addItem(checkItem)
        })
    }
}