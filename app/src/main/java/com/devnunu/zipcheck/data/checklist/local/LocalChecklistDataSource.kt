package com.devnunu.zipcheck.data.checklist.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devnunu.zipcheck.data.checklist.ChecklistDataSource
import com.devnunu.zipcheck.data.checklist.dao.ChecklistDao
import com.devnunu.zipcheck.data.checklist.entity.ChecklistEntity
import com.devnunu.zipcheck.data.checklist.model.Checklist
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalChecklistDataSource(
    private val checklistDao: ChecklistDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ChecklistDataSource {

    override fun observeCheckLists(): LiveData<List<ChecklistEntity>> {
        return checklistDao.observeChecklist()
    }

    override suspend fun insertChecklist(checklist: ChecklistEntity) = withContext(ioDispatcher) {
        checklistDao.insert(checklist)
    }
}