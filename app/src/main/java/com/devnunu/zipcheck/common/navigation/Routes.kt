package com.devnunu.zipcheck.common.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object BasicInfoInput : Routes("basicInfo/input")
    object BasicInfoDone : Routes("basicInfo/done") {
        const val ARGUMENTS_HOUSE_ID = "houseId"
        val arguments: List<NamedNavArgument> =
            listOf(navArgument(ARGUMENTS_HOUSE_ID) { defaultValue = "" })

        fun getArgumentsRoute(houseId: String? = null): String {
            val houseId = houseId ?: "{${ARGUMENTS_HOUSE_ID}}"
            return "${BasicInfoDone.route}?houseId=$houseId"
        }
    }
}