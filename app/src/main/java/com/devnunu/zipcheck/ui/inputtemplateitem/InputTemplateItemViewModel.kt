package com.devnunu.zipcheck.ui.inputtemplateitem

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.template.model.Template
import com.devnunu.zipcheck.data.template.repo.TemplateRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.data.template.model.CheckItem
import javax.inject.Inject

class InputTemplateItemViewModel @Inject constructor(
    private val houseRepository: HouseRepository,
    private val templateRepository: TemplateRepository
) : ViewModel() {

    var name: String? = null

    val checkItemName = MutableLiveData<String>()

    private val _template = MutableLiveData<Template>()
    val template: LiveData<Template> = _template

    val haveChecklistItem = _template.map {
        !it.items.isNullOrEmpty()
    }

    val isBottomBtnEnable = haveChecklistItem.map {
        it
    }

    /** event */
    private val _onClickAddItem = MutableLiveData<Event<CheckItem>>()
    val onClickAddItem: LiveData<Event<CheckItem>> = _onClickAddItem

    private val _onSuccessSaveTemplate = MutableLiveData<Event<Unit>>()
    val onSuccessSaveTemplate: LiveData<Event<Unit>> = _onSuccessSaveTemplate

    init {
        _template.value = Template()
    }

    fun setArgument(name: String) {
        this.name = name
    }

    /** button click handler */
    fun onClickAddItemBtn() {
        checkItemName.value?.let {
            _onClickAddItem.value = Event(CheckItem(it))
        }
        checkItemName.value = ""
    }

    fun onClickSubmitTemplateBtn() {
        val checklist = template.value
        checklist?.let {
            it.name = name
            templateRepository.saveChecklist(it)
            _onSuccessSaveTemplate.value = Event(Unit)
        }
    }
}