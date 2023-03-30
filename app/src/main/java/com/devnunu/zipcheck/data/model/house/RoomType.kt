package com.devnunu.zipcheck.data.model.house

enum class RoomType(val displayName:String) {
    ENTRANCE("현관"),
    LIVING_AND_KITCHEN("거실\\부엌"),
    ROOM1("방1"),
    ROOM2("방2"),
    BATHROOM("화장실");

    companion object {
        fun getRoomTypes(houseType: HouseType?): List<RoomType> =
            when (houseType) {
                HouseType.TYPE_A -> listOf(
                    ENTRANCE,
                    LIVING_AND_KITCHEN,
                    ROOM1,
                    BATHROOM
                )
                HouseType.TYPE_B,
                HouseType.TYPE_C,
                HouseType.TYPE_D -> listOf(
                    ENTRANCE,
                    LIVING_AND_KITCHEN,
                    ROOM1,
                    ROOM2,
                    BATHROOM
                )
                else -> emptyList()
            }
    }
}