package com.devnunu.zipcheck.data.checklist.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devnunu.zipcheck.data.checklist.ChecklistDataSource
import com.devnunu.zipcheck.data.checklist.model.Checklist

class LocalChecklistDataSource : ChecklistDataSource {

    private val checklists = MutableLiveData<MutableList<Checklist>>()

    override fun observeCheckLists(): LiveData<MutableList<Checklist>> {
        return checklists
    }

    override fun saveChecklist(checklist: Checklist) {
        var newChecklists = checklists.value
        if (newChecklists.isNullOrEmpty()) {
            newChecklists = mutableListOf(checklist)
        } else {
            newChecklists.add(checklist)
        }
        checklists.value = newChecklists
    }
}