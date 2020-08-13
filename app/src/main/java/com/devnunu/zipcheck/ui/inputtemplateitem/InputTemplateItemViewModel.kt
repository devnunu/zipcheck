package com.devnunu.zipcheck.ui.inputtemplateitem

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.template.model.Checklist
import com.devnunu.zipcheck.data.template.repo.TemplateRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.ui.inputtemplateitem.category.InputTemplateItemListener
import javax.inject.Inject

class InputTemplateItemViewModel @Inject constructor(
    private val houseRepository: HouseRepository,
    private val templateRepository: TemplateRepository
) : ViewModel(), InputTemplateItemListener {

    var name: String? = null

    val checkItem = MutableLiveData<String>()

    private val _checklist = MutableLiveData<Checklist>()
    val checklist: LiveData<Checklist> = _checklist

    val categoryNameList = _checklist.map {
        it.items?.keys?.toList()
    }

    val haveChecklistItem = _checklist.map {
        !it.items.isNullOrEmpty()
    }

    val isBottomBtnEnable = haveChecklistItem.map {
        it
    }

    /** event */
    private val _onSuccessSaveTemplate = MutableLiveData<Event<Unit>>()
    val onSuccessSaveTemplate: LiveData<Event<Unit>> = _onSuccessSaveTemplate

    init {
        _checklist.value = Checklist()
    }

    fun setArgument(name: String) {
        this.name = name
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

    override fun onClickAddCategoryItem(categoryName: String) {

    }

    /** button click handler */
    fun onClickAddItemBtn() {
        val checklist = _checklist.value
        checklist?.apply {
//            addCustomItem(categoryName, title)
        }
        _checklist.value = checklist
        checkItem.value = null
    }

    fun onClickSubmitTemplateBtn() {
        val checklist = checklist.value
        checklist?.let {
            it.name = name
            templateRepository.saveChecklist(it)
            _onSuccessSaveTemplate.value = Event(Unit)
        }
    }
}