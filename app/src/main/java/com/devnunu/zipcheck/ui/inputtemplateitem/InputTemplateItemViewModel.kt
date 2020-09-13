package com.devnunu.zipcheck.ui.inputtemplateitem

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.template.model.Template
import com.devnunu.zipcheck.data.template.repo.TemplateRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.data.template.model.CheckItem
import com.devnunu.zipcheck.ui.inputtemplateitem.item.InputTemplateItemListener
import javax.inject.Inject

class InputTemplateItemViewModel(
    private val houseRepository: HouseRepository,
    private val templateRepository: TemplateRepository
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
        val template = Template().apply {
            name = templateName
            items = _checkItems.value ?: mutableListOf()
        }
        templateRepository.saveChecklist(template)
        _onSuccessSaveTemplate.value = Event(Unit)
    }
}