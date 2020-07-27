package com.devnunu.zipcheck.ui.template

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import javax.inject.Inject

class CheckListTemplateViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

    private val _checklist = MutableLiveData<Checklist>()
    val checklist: LiveData<Checklist> = _checklist

}