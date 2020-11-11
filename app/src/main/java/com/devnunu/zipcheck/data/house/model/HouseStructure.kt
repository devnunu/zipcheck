package com.devnunu.zipcheck.data.house.model

enum class HouseStructure(val displayName: String) {
    ONE_ROOM("원룸"),
    TWO_ROOM("투룸"),
    THREE_ROOM("쓰리룸+");

    companion object {
        fun fromDisplayName(text: String?): HouseStructure? {
            values().forEach { houseStructure ->
                if (houseStructure.displayName.equals(text, ignoreCase = true)) {
                    return houseStructure
                }
            }
            return null
        }
    }
}