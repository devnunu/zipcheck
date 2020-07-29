package com.devnunu.zipcheck.ui.inputchecklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.checklist.repo.ChecklistRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.ui.inputchecklist.item.TemplateItemListener
import javax.inject.Inject

class InputCheckListViewModel @Inject constructor(
    private val houseRepository: HouseRepository,
    private val checklistRepository: ChecklistRepository
) : ViewModel(), TemplateItemListener {

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
        if (selIndex == index) {
            selChecklistIndex.value = null
        } else {
            selChecklistIndex.value = index
        }
    }

    /** event handler */
    fun onClickAddTemplateBtn() {
        _onClickAddTemplateBtn.value = Event(Unit)
    }

    fun onClickSubmitHouseBtn() {
        val house = houseRepository.getInputHouse()?.apply {
            val index = selChecklistIndex.value ?: 0
            checklist = checklists.value?.get(index)
        }
        house?.let {
            houseRepository.setInputHouse(null)
            houseRepository.addHouse(it)
            _onSuccessSubmitHouse.value = Event(Unit)
        }
    }
}