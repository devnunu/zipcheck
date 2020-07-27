package com.devnunu.zipcheck.ui.template

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.data.checklist.model.ChecklistType
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import javax.inject.Inject

class CheckListTemplateViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

    private val _checklist = MutableLiveData<Checklist>()

    val categoryNameList = _checklist.map {
        it.items.keys.toList()
    }

    fun start(defaultChecklistItems: List<ChecklistType?>) {
        _checklist.value = Checklist().apply {
            resetToDefaultItems(defaultChecklistItems)
        }
    }
}