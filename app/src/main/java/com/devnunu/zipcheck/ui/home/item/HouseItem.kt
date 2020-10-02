package com.devnunu.zipcheck.ui.home.item

import com.devnunu.zipcheck.common.ext.filteredAveragePoint
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType

class HouseItem(house: House) {

    val id = house.id

    val name = house.name

    val point = house.filteredAveragePoint

    val typeAndPriceText = getHousePrice(house)

    private fun getHousePrice(house: House): String {
        val houseType = house.houseType?.displayName
        val deposit = CurrencyUtil.toKrCurrencyText(house.deposit)
        return when (house.houseType) {
            HouseType.LEASE_MONTHLY_PAY -> {
                val monthlyPay = CurrencyUtil.toKrCurrencyText(house.monthlyPay)
                "$houseType $deposit/$monthlyPay"
            }
            else -> "$houseType $deposit"
        }
    }
}