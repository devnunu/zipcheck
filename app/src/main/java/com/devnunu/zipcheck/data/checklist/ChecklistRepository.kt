package com.devnunu.zipcheck.data.checklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devnunu.zipcheck.data.checklist.local.LocalChecklistDataSource
import com.devnunu.zipcheck.data.checklist.model.Checklist

interface ChecklistRepository {
    fun observeCheckLists(): LiveData<MutableList<Checklist>>
    fun saveChecklist(checklist: Checklist)
}

class DefaultChecklistRepository(
    private val localChecklistDataSource: ChecklistDataSource
) : ChecklistRepository {

    override fun observeCheckLists(): LiveData<MutableList<Checklist>> {
        return localChecklistDataSource.observeCheckLists()
    }

    override fun saveChecklist(checklist: Checklist) {
        localChecklistDataSource.saveChecklist(checklist)
    }
}