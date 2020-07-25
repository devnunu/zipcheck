package com.example.myapplication.data.house.model

import java.util.*

class House {
    var id: String = UUID.randomUUID().toString()
    var name: String = ""
    var description: String = ""
    var favorites: Boolean = false
    var deposit: Int = 0
    var monthlyPay: Int = 0
    var memo: String = ""
    val checkLists: List<CheckListItem> = mutableListOf()
}