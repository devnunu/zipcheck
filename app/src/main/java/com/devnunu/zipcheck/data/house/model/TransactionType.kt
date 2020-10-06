package com.devnunu.zipcheck.data.house.model

enum class TransactionType(val displayName: String) {
    LEASE_MONTHLY_PAY("월세"),
    LEASE_RENT("전세"),
    TRADE("매매");

    companion object {
        fun fromDisplayName(text: String?): TransactionType? {
            values().forEach { houseType ->
                if (houseType.displayName.equals(text, ignoreCase = true)) {
                    return houseType
                }
            }
            return null
        }
    }
}