package com.devnunu.zipcheck.ui.home.item

import com.devnunu.zipcheck.common.util.CurrencyUtil
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.data.house.model.HouseType

class HouseItem(house: House) {

    val id = house.id

    val name = house.name

    val typeAndPriceText = getHousePrice(house)

    val checklistCountText = getCheckStatus(house)

    private fun getCheckStatus(house: House): String {
        var totalChecklistCount = 0
        var checkedItemCount = 0

        return "${checkedItemCount}/${totalChecklistCount}"
    }

    private fun getHousePrice(house: House): String {
        return when (house.houseType) {
            HouseType.LEASE_MONTHLY_PAY ->
                "${house.houseType?.displayName} ${CurrencyUtil.toKrCurrencyText(house.deposit)}/${CurrencyUtil.toKrCurrencyText(
                    house.monthlyPay
                )}"
            else -> "${house.houseType?.displayName} ${CurrencyUtil.toKrCurrencyText(house.deposit)}"
        }
    }
}