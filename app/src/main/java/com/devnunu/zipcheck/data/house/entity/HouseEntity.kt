package com.devnunu.zipcheck.data.house.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devnunu.zipcheck.data.house.model.CheckItem
import com.devnunu.zipcheck.data.house.model.HouseStructure
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.data.house.model.TransactionType

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
    val transactionType: TransactionType?,
    val checklist: List<CheckItem>,
    val area: Int?,
    val floor: Int?,
    val elevator:Boolean?,
    val structure: HouseStructure?,
    val parking: Boolean?,
    val managementFee: Int?,
    val houseType: HouseType?
)