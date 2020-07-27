package com.devnunu.zipcheck.data.house.model

import com.devnunu.zipcheck.data.checklist.model.ChecklistItem
import java.util.*

class House {
    var id: String = UUID.randomUUID().toString()
    var name: String = ""
    var description: String = ""
    var favorites: Boolean = false
    var deposit: Long = 0
    var monthlyPay: Long = 0
    var memo: String = ""
    var houseType: HouseType? = null
    val checklists: List<ChecklistItem> = mutableListOf()
}