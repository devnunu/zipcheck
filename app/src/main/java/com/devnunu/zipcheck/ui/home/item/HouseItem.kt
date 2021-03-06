package com.devnunu.zipcheck.ui.home.item

import com.devnunu.zipcheck.common.ext.filteredAveragePoint
import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.TransactionType
import kotlin.math.roundToInt

class HouseItem(house: House) {

    val id = house.id

    val name = house.name

    val point = house.filteredAveragePoint

    val pointText = ((house.filteredAveragePoint * 100).roundToInt() /100f).toString()

    val typeAndPriceText = getHousePrice(house)

    private fun getHousePrice(house: House): String {
        val houseType = house.transactionType?.displayName
        val deposit = CurrencyUtil.toKrCurrencyText(house.deposit)
        return when (house.transactionType) {
            TransactionType.LEASE_MONTHLY_PAY -> {
                val monthlyPay = CurrencyUtil.toKrCurrencyText(house.monthlyPay)
                "$houseType $deposit/$monthlyPay"
            }
            else -> "$houseType $deposit"
        }
    }
}