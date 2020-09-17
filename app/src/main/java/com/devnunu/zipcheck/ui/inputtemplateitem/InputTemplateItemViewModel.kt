package com.devnunu.zipcheck.ui.inputtemplateitem

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.checklist.repo.ChecklistRepository
import com.devnunu.zipcheck.data.checklist.model.CheckItem
import com.devnunu.zipcheck.ui.inputtemplateitem.item.InputTemplateItemListener

class InputTemplateItemViewModel(
    private val checklistRepository: ChecklistRepository
) : ViewModel(), InputTemplateItemListener {

    private var templateName: String? = null

    val checkItemName = MutableLiveData<String>()

    private val _checkItems = MutableLiveData<MutableList<CheckItem>>()

    val isBottomBtnEnable = _checkItems.map {
        !it.isNullOrEmpty()
    }

    /** event */
    private val _onClickAddItem = MutableLiveData<Event<CheckItem>>()
    val onClickAddItem: LiveData<Event<CheckItem>> = _onClickAddItem

    private val _onSuccessSaveTemplate = MutableLiveData<Event<Unit>>()
    val onSuccessSaveTemplate: LiveData<Event<Unit>> = _onSuccessSaveTemplate

    fun setArgument(name: String) {
        this.templateName = name
    }

    /** item listener */
    override fun onChangeCheckItems(checkItems: MutableList<CheckItem>) {
        _checkItems.value = checkItems
    }

    /** button click handler */
    fun onClickAddItemBtn() {
        val name = checkItemName.value
        if(!name.isNullOrEmpty()) {
            _onClickAddItem.value = Event(CheckItem(name))
        }
        checkItemName.value = ""
    }

    fun onClickSubmitTemplateBtn() {
        val template = Checklist().apply {
            name = templateName
            items = _checkItems.value ?: mutableListOf()
        }
        checklistRepository.saveChecklist(template)
        _onSuccessSaveTemplate.value = Event(Unit)
    }
}