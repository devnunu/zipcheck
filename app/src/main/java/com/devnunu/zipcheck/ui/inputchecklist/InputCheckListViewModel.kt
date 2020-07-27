package com.devnunu.zipcheck.ui.inputchecklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.common.Event
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import javax.inject.Inject

class InputCheckListViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

    /** event */
    private val _onClickAddTemplateBtn = MutableLiveData<Event<Unit>>()
    val onClickAddTemplateBtn: LiveData<Event<Unit>> = _onClickAddTemplateBtn

    /** event handler */
    fun onClickAddTemplateBtn() {
        _onClickAddTemplateBtn.value = Event(Unit)
    }
}