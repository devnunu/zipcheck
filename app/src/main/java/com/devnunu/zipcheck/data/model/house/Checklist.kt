package com.devnunu.zipcheck.data.model.house

data class Checklist(
    val entranceChecklists: List<String> = emptyList(),
    val livingAndKitchenChecklists: List<String> = emptyList(),
    val room1Checklists: List<String> = emptyList(),
    val room2Checklist: List<String> = emptyList(),
    val bathRoomChecklist: List<String> = emptyList(),
) {
    fun getChecklist(roomType: RoomType?) =
        when (roomType) {
            RoomType.ENTRANCE -> entranceChecklists
            RoomType.LIVING_AND_KITCHEN -> livingAndKitchenChecklists
            RoomType.ROOM1 -> room1Checklists
            RoomType.ROOM2 -> room2Checklist
            RoomType.BATHROOM -> bathRoomChecklist
            else -> emptyList()
        }

    companion object {

        private val plainEntranceChecklist = listOf(
            "현관 잠금장치가 안전해요"
        )

        private val plainLivingAndKitchenChecklist = listOf(
            "채광이 잘들어요",
            "크기가 적당해요",
            "도배상태가 깨끗해요",
        )

        private val plainRoom1Checklist = listOf(
            "채광이 잘들어요",
            "크기가 적당해요",
            "곰팡이가 없어요",
        )

        private val plainRoom2Checklist = listOf(
            "채광이 잘들어요",
            "크기가 적당해요",
            "곰팡이가 없어요",
        )

        private val plainBathRoomChecklist = listOf(
            "샤워기 상태",
            "수압",
            "곰팡이가 없어요",
            "변기 상태가 좋아요",
            "수납장이 깨끗해요",
        )

        fun getPlainChecklist(roomType: RoomType?) =
            when (roomType) {
                RoomType.ENTRANCE -> plainEntranceChecklist
                RoomType.LIVING_AND_KITCHEN -> plainLivingAndKitchenChecklist
                RoomType.ROOM1 -> plainRoom1Checklist
                RoomType.ROOM2 -> plainRoom2Checklist
                RoomType.BATHROOM -> plainBathRoomChecklist
                else -> emptyList()
            }
    }
}