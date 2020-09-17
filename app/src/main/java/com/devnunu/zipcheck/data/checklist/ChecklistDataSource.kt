package com.devnunu.zipcheck.data.checklist

import androidx.lifecycle.LiveData
import com.devnunu.zipcheck.data.checklist.model.Checklist

interface ChecklistDataSource {
    fun observeCheckLists(): LiveData<MutableList<Checklist>>
    fun saveChecklist(checklist: Checklist)
}