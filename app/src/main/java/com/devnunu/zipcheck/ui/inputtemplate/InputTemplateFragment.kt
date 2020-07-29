package com.devnunu.zipcheck.ui.inputtemplate

import android.text.InputType
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.data.checklist.model.ChecklistType
import com.devnunu.zipcheck.databinding.FragmentInputTemplateBinding
import com.devnunu.zipcheck.ui.inputtemplate.category.ChecklistCategoryItemAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class InputTemplateFragment :
    BaseFragment<FragmentInputTemplateBinding, InputInputTemplateViewModel>(
        R.layout.fragment_input_template,
        InputInputTemplateViewModel::class
    ) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.listCategoryName.adapter =
                ChecklistCategoryItemAdapter(viewModel)
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddCategoryBtn.observe(this, EventObserver {
            showItemSelectDialog()
        })

        viewModel.onClickAddCustomItemBtn.observe(this, EventObserver {
            showCustomCheckItemDialog()
        })

        viewModel.onSuccessSaveTemplate.observe(this, EventObserver {
            findNavController().navigateUp()
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

    private fun showCustomCheckItemDialog() {
        val input = EditText(requireContext())
        input.inputType = InputType.TYPE_CLASS_TEXT
        input.maxLines = 1
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("나의 체크 아이템")
            .setPositiveButton("확인") { _, _ ->
                viewModel.addCustomChecklistItem(input.text.toString())
            }
            .setView(input)
            .show()
    }
}