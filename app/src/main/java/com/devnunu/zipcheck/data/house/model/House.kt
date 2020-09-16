package com.devnunu.zipcheck.data.house.model

import com.devnunu.zipcheck.data.template.model.Checklist
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
    var checklist: Checklist? = null
}