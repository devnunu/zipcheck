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

    private val _onClickAddCustomItemBtn = MutableLiveData<Event<Unit>>()
    val onClickAddCustomItemBtn: LiveData<Event<Unit>> = _onClickAddCustomItemBtn

    init {
        _checklist.value = Checklist()
    }

    fun addChecklistCategories(selChecklistCategories: List<ChecklistType?>) {
        val checklist = _checklist.value
        checklist?.apply {
            addDefaultItems(selChecklistCategories)
        }
        _checklist.value = checklist
    }

    fun addCustomChecklistItem(title: String?) {
        val checklist = _checklist.value
        checklist?.apply {
            addCustomItem(title)
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
        checklist?.items?.remove(categoryName)
        _checklist.value = checklist

    }

    override fun onClickRemoveChecklistItem(categoryName: String, index: Int) {
        val checklist = _checklist.value
        val checkItemList = checklist?.items?.get(categoryName)
        checkItemList?.removeAt(index)
        if (checkItemList.isNullOrEmpty()) {
            onClickRemoveCategory(categoryName)
        } else {
            checklist.items?.put(categoryName, checkItemList)
            _checklist.value = checklist
        }
    }

    /** button click handler */
    fun onClickAddCategoryBtn() {
        _onClickAddCategoryBtn.value = Event(Unit)
    }

    fun onClickAddCustomItemBtn() {
        _onClickAddCustomItemBtn.value = Event(Unit)
    }
}