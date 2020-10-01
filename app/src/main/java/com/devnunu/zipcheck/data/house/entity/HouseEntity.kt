package com.devnunu.zipcheck.data.house.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devnunu.zipcheck.data.house.model.CheckItem
import com.devnunu.zipcheck.data.house.model.HouseType

@Entity(tableName = "House")
data class HouseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String?,
    val favorites: Boolean?,
    val deposit: Long?,
    val monthlyPay: Long?,
    val memo: String?,
    val houseType: HouseType?,
    val checklist: List<CheckItem>?
)