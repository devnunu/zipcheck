package com.devnunu.zipcheck.data.checklist.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devnunu.zipcheck.data.checklist.model.Checklist

class ChecklistRepository {
    private val checklists = MutableLiveData<MutableList<Checklist>>()

    fun observeCheckLists(): LiveData<MutableList<Checklist>> {
        return checklists
    }

    fun saveChecklist(checklist: Checklist) {
        var newChecklists = checklists.value
        if (newChecklists.isNullOrEmpty()) {
            newChecklists = mutableListOf(checklist)
        } else {
            newChecklists.add(checklist)
        }
        checklists.value = newChecklists
    }
}