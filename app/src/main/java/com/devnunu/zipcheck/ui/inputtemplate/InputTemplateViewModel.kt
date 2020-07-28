package com.devnunu.zipcheck.ui.inputtemplate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.checklist.model.ChecklistType
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.ui.inputtemplate.category.TemplateItemListener
import javax.inject.Inject

class InputTemplateViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel(), TemplateItemListener {

    private val _checklist = MutableLiveData<Checklist>()
    val checklist: LiveData<Checklist> = _checklist

    val categoryNameList = _checklist.map {
        it.items?.keys?.toList()
    }

    fun start(defaultChecklistItems: List<ChecklistType?>) {
        _checklist.value = Checklist().apply {
            resetToDefaultItems(defaultChecklistItems)
        }
    }

    override fun onClickRemoveCategory(categoryName: String) {
        val checklist = _checklist.value
        val checklistItems = checklist?.items?.toMutableMap()
        checklistItems?.remove(categoryName)
        checklist?.items = checklistItems?.toMap()
        _checklist.value = checklist

    }

    override fun onClickRemoveChecklistItem(categoryName: String, index: Int) {
        val checklist = _checklist.value
        val checklistItems = checklist?.items?.toMutableMap()
        val checkItemList = checklistItems?.get(categoryName)?.toMutableList() ?: mutableListOf()
        checkItemList.removeAt(index)
        checklistItems?.put(categoryName, checkItemList.toList())
        checklist?.items = checklistItems?.toMap()
        _checklist.value = checklist
    }
}