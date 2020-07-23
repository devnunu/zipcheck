package com.example.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*

@Entity(tableName = "houses")
data class House(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "houseId")
    var id: String,
    var name: String = "",
    var description: String = "",
    var favorites: Boolean = false,
    var deposit: Int = 0,
    var monthlyPay: Int = 0,
    var memo: String = "",
    @Relation(
        parentColumn = "houseId",
        entityColumn = "checkListItemId"
    )
    val checkLists: List<CheckListItem>
)

data class CheckListItem(
    @PrimaryKey
    @ColumnInfo(name = "checkListItemId")
    val id: Long,
    var description: String,
    var isChecked: Boolean
)

