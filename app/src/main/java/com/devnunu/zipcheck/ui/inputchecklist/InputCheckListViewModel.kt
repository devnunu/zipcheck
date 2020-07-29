package com.devnunu.zipcheck.ui.inputchecklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.checklist.repo.ChecklistRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import javax.inject.Inject

class InputCheckListViewModel @Inject constructor(
    private val houseRepository: HouseRepository,
    private val checklistRepository: ChecklistRepository
) : ViewModel() {

    val checklists = checklistRepository.observeCheckLists()

    var selChecklist: Checklist? = null

    val haveChecklist = checklists.map {
        !it.isNullOrEmpty()
    }

    /** event */
    private val _onClickAddTemplateBtn = MutableLiveData<Event<Unit>>()
    val onClickAddTemplateBtn: LiveData<Event<Unit>> = _onClickAddTemplateBtn

    private val _onSuccessSubmitHouse = MutableLiveData<Event<Unit>>()
    val onSuccessSubmitHouse: LiveData<Event<Unit>> = _onSuccessSubmitHouse

    /** event handler */
    fun onClickAddTemplateBtn() {
        _onClickAddTemplateBtn.value = Event(Unit)
    }

    fun onClickSubmitHouseBtn() {
        val house = houseRepository.getInputHouse()?.apply {
            checklist = selChecklist
        }
        houseRepository.setInputHouse(house)
        _onSuccessSubmitHouse.value = Event(Unit)
    }
}