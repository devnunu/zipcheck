package com.devnunu.zipcheck.data.checklist.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devnunu.zipcheck.data.checklist.entity.ChecklistEntity
import com.devnunu.zipcheck.data.checklist.model.Checklist

@Dao
interface ChecklistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(checklist: ChecklistEntity)

    @Query("select * from checklist")
    fun observeChecklist(): LiveData<List<ChecklistEntity>>
}