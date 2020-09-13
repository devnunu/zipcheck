package com.devnunu.zipcheck.ui.inputtemplate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.template.repo.TemplateRepository
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import com.devnunu.zipcheck.ui.inputtemplate.item.TemplateItemListener
import javax.inject.Inject

class InputTemplateViewModel(
    private val houseRepository: HouseRepository,
    private val templateRepository: TemplateRepository
) : ViewModel(), TemplateItemListener {

    val checklists = templateRepository.observeCheckLists()

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
            template = checklists.value?.get(index)
        }
        house?.let {
            houseRepository.setInputHouse(null)
            houseRepository.addHouse(it)
            _onSuccessSubmitHouse.value = Event(Unit)
        }
    }
}