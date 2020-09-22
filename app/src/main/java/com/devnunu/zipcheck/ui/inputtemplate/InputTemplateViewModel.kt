package com.devnunu.zipcheck.ui.inputtemplate

import androidx.lifecycle.*
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.checklist.ChecklistRepository
import com.devnunu.zipcheck.data.house.HouseRepository
import com.devnunu.zipcheck.ui.inputtemplate.item.TemplateItemListener
import kotlinx.coroutines.launch

class InputTemplateViewModel(
    private val houseRepository: HouseRepository,
    private val checklistRepository: ChecklistRepository
) : ViewModel(), TemplateItemListener {

    var houseId = MutableLiveData<Int>()

    private val _house = houseId.switchMap {
        houseRepository.observeHouse(it)
    }

    val checklists = checklistRepository.observeCheckLists()

    var selChecklistIndex = MutableLiveData<Int>()

    val isButtonEnable = selChecklistIndex.map {
        it != null
    }

    val haveChecklist = checklists.map {
        !it.isNullOrEmpty()
    }

    /** event */
    private val _onClickAddTemplateBtn = MutableLiveData<Event<Unit>>()
    val onClickAddTemplateBtn: LiveData<Event<Unit>> = _onClickAddTemplateBtn

    private val _onSuccessSubmitHouse = MutableLiveData<Event<Unit>>()
    val onSuccessSubmitHouse: LiveData<Event<Unit>> = _onSuccessSubmitHouse

    /** 템플릿 선택시 */
    override fun onSelectTemplate(index: Int) {
        val selIndex = selChecklistIndex.value
        selChecklistIndex.value = if (selIndex == index) null else index
    }

    /** event handler */
    fun onClickAddTemplateBtn() {
        _onClickAddTemplateBtn.value = Event(Unit)
    }

    fun onClickSubmitHouseBtn() {
        viewModelScope.launch {
            val houseId = _house.value?.id
            val index = selChecklistIndex.value ?: 0
            val checklist = checklists.value?.get(index)

            if (houseId != null && checklist != null) {
                houseRepository.updateHouseChecklist(houseId, checklist)
                _onSuccessSubmitHouse.value = Event(Unit)
            }
        }
    }
}