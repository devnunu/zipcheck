package com.devnunu.zipcheck.ui.inputtemplate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.checklist.model.ChecklistType
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.ui.inputtemplate.category.TemplateItemListener
import javax.inject.Inject

class InputTemplateViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel(), TemplateItemListener {

    val name = MutableLiveData<String>()

    private val _checklist = MutableLiveData<Checklist>()
    val checklist: LiveData<Checklist> = _checklist

    val categoryNameList = _checklist.map {
        it.items?.keys?.toList()
    }

    val haveChecklistItem = _checklist.map {
        !it.items.isNullOrEmpty()
    }

    /** event */
    private val _onClickAddCategoryBtn = MutableLiveData<Event<Unit>>()
    val onClickAddCategoryBtn: LiveData<Event<Unit>> = _onClickAddCategoryBtn

    init {
        _checklist.value = Checklist()
    }

    fun addChecklistItems(defaultChecklistItems: List<ChecklistType?>) {
        val checklist = _checklist.value
        checklist?.apply {
            addDefaultItems(defaultChecklistItems)
        }
        _checklist.value = checklist
    }

    fun getCategoryList(): Array<String> {
        val categoryNames = checklist.value?.items?.keys?.toList()
        return ChecklistType.values().filter {
            val isNotAddedCategory = categoryNames?.contains(it.displayName)?.not() ?: true
            val isNotCustomType = ChecklistType.CHECKLIST_TYPE_USER_CUSTOM != it
            isNotAddedCategory && isNotCustomType
        }.map {
            it.displayName
        }.toTypedArray()
    }

    /** checklist item click handler */
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
        if (checkItemList.isEmpty()) {
            onClickRemoveCategory(categoryName)
        } else {
            checklistItems?.put(categoryName, checkItemList.toList())
            checklist?.items = checklistItems?.toMap()
            _checklist.value = checklist
        }
    }

    /** button click handler */
    fun onClickAddCategoryBtn() {
        _onClickAddCategoryBtn.value = Event(Unit)
    }
}