package com.devnunu.zipcheck.data.checklist.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devnunu.zipcheck.data.checklist.model.CheckItem

@Entity(tableName = "Checklist")
data class ChecklistEntity(

    @PrimaryKey(autoGenerate = true)
    val checklistId: Int,

    val name: String,

    val items: List<CheckItem>
)