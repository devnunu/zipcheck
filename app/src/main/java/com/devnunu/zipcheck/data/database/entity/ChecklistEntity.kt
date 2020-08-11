package com.devnunu.zipcheck.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checklists")
data class ChecklistEntity(
    @PrimaryKey(autoGenerate = true)
    var Id: Int,
    var name: String
)