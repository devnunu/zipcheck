package com.devnunu.zipcheck.data.checklist

import androidx.lifecycle.LiveData
import com.devnunu.zipcheck.data.checklist.entity.ChecklistEntity
import com.devnunu.zipcheck.data.checklist.model.Checklist

interface ChecklistDataSource {
    fun observeCheckLists(): LiveData<List<ChecklistEntity>>
    suspend fun insertChecklist(checklist: ChecklistEntity)
}