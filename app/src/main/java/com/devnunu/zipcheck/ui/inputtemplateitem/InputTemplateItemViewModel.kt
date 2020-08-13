package com.devnunu.zipcheck.ui.inputtemplateitem

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.template.model.Template
import com.devnunu.zipcheck.data.template.repo.TemplateRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.data.template.model.CheckItem
import com.devnunu.zipcheck.ui.inputtemplateitem.category.InputTemplateItemListener
import javax.inject.Inject

class InputTemplateItemViewModel @Inject constructor(
    private val houseRepository: HouseRepository,
    private val templateRepository: TemplateRepository
) : ViewModel(), InputTemplateItemListener {

    var name: String? = null

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
        this.name = name
    }

    /** item listener */
    override fun onChangeCheckItems(checkItems: MutableList<CheckItem>) {
        _checkItems.value = checkItems
    }

    /** button click handler */
    fun onClickAddItemBtn() {
        checkItemName.value?.let {
            _onClickAddItem.value = Event(CheckItem(it))
        }
        checkItemName.value = ""
    }

    fun onClickSubmitTemplateBtn() {
        val template = Template().apply {
            this.name = name
            this.items = _checkItems.value ?: mutableListOf()
        }
        templateRepository.saveChecklist(template)
        _onSuccessSaveTemplate.value = Event(Unit)
    }
}