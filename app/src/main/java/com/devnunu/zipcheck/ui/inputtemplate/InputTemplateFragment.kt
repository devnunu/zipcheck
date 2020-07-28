package com.devnunu.zipcheck.ui.inputtemplate

import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.data.checklist.model.ChecklistType
import com.devnunu.zipcheck.databinding.FragmentInputTemplateBinding
import com.devnunu.zipcheck.ui.inputtemplate.category.ChecklistCategoryItemAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class InputTemplateFragment :
    BaseFragment<FragmentInputTemplateBinding, InputTemplateViewModel>(
        R.layout.fragment_input_template,
        InputTemplateViewModel::class
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
                viewModel.addChecklistItems(items)
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
}