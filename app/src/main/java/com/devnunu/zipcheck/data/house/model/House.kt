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
    var area: Int? = null,
    var floor: Int? = null,
    var elevator:Boolean? = null,
    var structure: HouseStructure? = null,
    var parking: Boolean? = null,
    var managementFee: Int? = null,
    var houseType: HouseType? = null
)