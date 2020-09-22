package com.devnunu.zipcheck.data.checklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.devnunu.zipcheck.data.checklist.entity.ChecklistEntity
import com.devnunu.zipcheck.data.checklist.mapper.toChecklist
import com.devnunu.zipcheck.data.checklist.mapper.toChecklistEntity
import com.devnunu.zipcheck.data.checklist.model.Checklist
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ChecklistRepository {
    fun observeCheckLists(): LiveData<List<Checklist>>
    suspend fun insertChecklist(checklist: Checklist)
}

class DefaultChecklistRepository(
    private val localChecklistDataSource: ChecklistDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ChecklistRepository {

    override fun observeCheckLists(): LiveData<List<Checklist>> {
        return localChecklistDataSource.observeCheckLists()
            .map { it.map(ChecklistEntity::toChecklist) }
    }

    override suspend fun insertChecklist(checklist: Checklist) = withContext(ioDispatcher) {
        localChecklistDataSource.insertChecklist(checklist.toChecklistEntity())
    }
}