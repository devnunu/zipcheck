package com.devnunu.zipcheck.data.model

import com.devnunu.zipcheck.R
import java.util.*

data class House(
    val id: String = UUID.randomUUID().toString(),
    val imgNum: Int = (1..4).random(),
    val alias: String? = null,
    val roomType: RoomType = RoomType.TYPE_A,
    val roomArea: RoomArea = RoomArea(type = RoomAreaType.PYONG),
    val depositAmount: Long? = null,
    val monthlyAmount: Long? = null,
    val maintenanceCost: Long? = null,
    val memo: String? = null,
    val roomInfoUrl: String? = null,
    var houseWriteStatus: HouseWriteStatus = HouseWriteStatus.IN_PROGRESS
) {
    val isNoMonthlyAmount: Boolean
        get() = monthlyAmount != null && monthlyAmount == 0L

    val isNoMaintenanceCost: Boolean
        get() = maintenanceCost != null && maintenanceCost == 0L

    val imgResId: Int
        get() = when (imgNum) {
            1 -> R.drawable.ic_house1
            2 -> R.drawable.ic_house2
            3 -> R.drawable.ic_house3
            else -> R.drawable.ic_house4
        }
}