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
            it.listCategoryName.adapter =
                InputChecklistCategoryItemAdapter(viewModel)
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddCategoryBtn.observe(this, EventObserver {
            showItemSelectDialog()
        })

        viewModel.onClickAddCustomItemBtn.observe(this, EventObserver {
            showCustomCheckItemDialog(it)
        })

        viewModel.onSuccessSaveTemplate.observe(this, EventObserver {
            val action =
                InputTemplateItemFragmentDirections.actionCheckListTemplateFragmentToInputCheckListFragment()
            findNavController().navigate(action)
        })
    }

    private fun showItemSelectDialog() {
        val keyArray = viewModel.getCategoryList()
        val selectedItems = mutableListOf<Int>()
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("템플릿 추가요소")
            .setPositiveButton("확인") { _, _ ->
                val items = selectedItems.map {
                    ChecklistType.fromDisplayName(keyArray[it])
                }
                viewModel.addChecklistCategories(items)
            }
            .setMultiChoiceItems(keyArray, null) { dialog, which, checked ->
                if (checked) {
                    selectedItems.add(which)
                } else if (selectedItems.contains(which)) {
                    selectedItems.remove(Integer.valueOf(which))
                }
            }
            .show()
    }

    private fun showCustomCheckItemDialog(categoryName: String) {
        val input = EditText(requireContext())
        input.inputType = InputType.TYPE_CLASS_TEXT
        input.maxLines = 1
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("나의 체크 아이템")
            .setPositiveButton("확인") { _, _ ->
                viewModel.addCustomChecklistItem(categoryName, input.text.toString())
            }
            .setView(input)
            .show()
    }
}