package com.devnunu.zipcheck.ui.inputtemplatename

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.devnunu.zipcheck.common.Event
import javax.inject.Inject

class InputTemplateNameViewModel @Inject constructor(
)  : ViewModel() {

    val name = MutableLiveData<String>()

    val isButtonEnable = name.map {
        !it.isNullOrEmpty()
    }

    /** event */
    private val _onClickNextBtn = MutableLiveData<Event<String?>>()
    val onClickNextBtn: LiveData<Event<String?>> = _onClickNextBtn


    /** button click handler */
    fun onClickNextBtn() {
        _onClickNextBtn.value = Event(name.value)
    }
}