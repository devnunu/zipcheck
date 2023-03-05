package com.devnunu.zipcheck.data.model

import java.util.*

data class House(
    val id: String = UUID.randomUUID().toString(),
    val alias: String? = null,
    val roomType: RoomType = RoomType.TYPE_A,
    val roomArea: RoomArea = RoomArea(type = RoomAreaType.PYONG),
    val depositAmount: Long? = null,
    val monthlyAmount: Long? = null,
    val maintenanceCost: Long? = null,
    val memo: String? = null,
    val roomInfoUrl: String? = null,
) {
    val isNoMonthlyAmount: Boolean
        get() = monthlyAmount != null && monthlyAmount == 0L

    val isNoMaintenanceCost: Boolean
        get() = maintenanceCost != null && maintenanceCost == 0L
}