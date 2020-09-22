package com.devnunu.zipcheck.data.house.model

import com.devnunu.zipcheck.data.checklist.model.Checklist
import java.util.*

data class House(
    var id: Int,
    var name: String,
    var description: String? = null,
    var favorites: Boolean? = false,
    var deposit: Long? = 0,
    var monthlyPay: Long? = 0,
    var memo: String? = null,
    var houseType: HouseType?,
    var checklist: Checklist?
)