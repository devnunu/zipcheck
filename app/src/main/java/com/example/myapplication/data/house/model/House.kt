package com.example.myapplication.data.house.model

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
    val checkLists: List<CheckListItem> = mutableListOf()
}