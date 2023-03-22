package com.devnunu.zipcheck.data.model.house

data class RoomTypeChecklist(
    val name: String = "",
    val checklist: List<ChecklistItem> = emptyList()
) {
    companion object {
        val ENTRANCE = RoomTypeChecklist(
            name = "현관",
            checklist = listOf(
                ChecklistItem(name = "현관 잠금장치가 안전해요")
            )
        )

        val LIVING_AND_KITCHEN = RoomTypeChecklist(
            name = "거실/부엌",
            checklist = listOf(
                ChecklistItem(name = "채광이 잘들어요"),
                ChecklistItem(name = "크기가 적당해요"),
                ChecklistItem(name = "도배상태가 깨끗해요"),
            )
        )

        val ROOM1 = RoomTypeChecklist(
            name = "방1",
            checklist = listOf(
                ChecklistItem(name = "채광이 잘들어요"),
                ChecklistItem(name = "크기가 적당해요"),
                ChecklistItem(name = "곰팡이가 없어요"),
            )
        )

        val ROOM2 = RoomTypeChecklist(
            name = "방2",
            checklist = listOf(
                ChecklistItem(name = "채광이 잘들어요"),
                ChecklistItem(name = "크기가 적당해요"),
                ChecklistItem(name = "곰팡이가 없어요"),
            )
        )

        val BATHROOM = RoomTypeChecklist(
            name = "화장실",
            checklist = listOf(
                ChecklistItem(name = "샤워기 상태"),
                ChecklistItem(name = "수압"),
                ChecklistItem(name = "곰팡이가 없어요"),
                ChecklistItem(name = "변기 상태가 좋아요"),
                ChecklistItem(name = "수납장이 깨끗해요"),
            )
        )

        fun getEssentialRoomTypeChecklist(): List<RoomTypeChecklist> =
            listOf(
                ENTRANCE,
                LIVING_AND_KITCHEN,
                ROOM1,
                ROOM2,
                BATHROOM
            )

        fun getChecklist(houseType: HouseType?): List<String> =
            when (houseType) {
                HouseType.TYPE_A -> listOf(
                    ENTRANCE.name,
                    LIVING_AND_KITCHEN.name,
                    ROOM1.name,
                    BATHROOM.name
                )
                HouseType.TYPE_B -> listOf(
                    ENTRANCE.name,
                    LIVING_AND_KITCHEN.name,
                    ROOM1.name,
                    ROOM2.name,
                    BATHROOM.name
                )
                HouseType.TYPE_C -> listOf(
                    ENTRANCE.name,
                    LIVING_AND_KITCHEN.name,
                    ROOM1.name,
                    ROOM2.name,
                    BATHROOM.name
                )
                HouseType.TYPE_D -> listOf(
                    ENTRANCE.name,
                    LIVING_AND_KITCHEN.name,
                    ROOM1.name,
                    ROOM2.name,
                    BATHROOM.name
                )
                else -> emptyList()
            }
    }
}