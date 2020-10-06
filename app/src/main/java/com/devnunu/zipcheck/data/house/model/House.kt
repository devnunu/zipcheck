package com.devnunu.zipcheck.data.house.model

data class House(
    var id: Int,
    var name: String,
    var description: String? = null,
    var favorites: Boolean? = false,
    var deposit: Long? = 0,
    var monthlyPay: Long? = 0,
    var memo: String? = null,
    var transactionType: TransactionType?,
    val checklist: List<CheckItem>,
    val area: Int? = null,
    val floor: Int? = null,
    val structure: HouseStructure? = null,
    val parking: Int? = null,
    val managementFee: Int? = null,
    val houseType: HouseType? = null
)