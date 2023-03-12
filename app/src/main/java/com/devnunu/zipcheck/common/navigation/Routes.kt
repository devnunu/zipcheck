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

    object TempBasicInfo : Routes("temp/basicInfo") {
        const val ARGUMENTS_HOUSE_ID = "houseId"
        val arguments: List<NamedNavArgument> =
            listOf(navArgument(ARGUMENTS_HOUSE_ID) { defaultValue = "" })

        fun getArgumentsRoute(houseId: String? = null): String {
            val houseId = houseId ?: "{${ARGUMENTS_HOUSE_ID}}"
            return "${TempBasicInfo.route}?houseId=$houseId"
        }
    }

    object TempOptionInfo : Routes("temp/option") {
        const val ARGUMENTS_HOUSE_ID = "houseId"
        val arguments: List<NamedNavArgument> =
            listOf(navArgument(ARGUMENTS_HOUSE_ID) { defaultValue = "" })

        fun getArgumentsRoute(houseId: String? = null): String {
            val houseId = houseId ?: "{${ARGUMENTS_HOUSE_ID}}"
            return "${TempOptionInfo.route}?houseId=$houseId"
        }
    }

    object TempSummary : Routes("temp/summary") {
        const val ARGUMENTS_HOUSE_ID = "houseId"
        val arguments: List<NamedNavArgument> =
            listOf(navArgument(ARGUMENTS_HOUSE_ID) { defaultValue = "" })

        fun getArgumentsRoute(houseId: String? = null): String {
            val houseId = houseId ?: "{${ARGUMENTS_HOUSE_ID}}"
            return "${TempSummary.route}?houseId=$houseId"
        }
    }

    object TempDone : Routes("temp/done") {
        const val ARGUMENTS_HOUSE_ID = "houseId"
        val arguments: List<NamedNavArgument> =
            listOf(navArgument(ARGUMENTS_HOUSE_ID) { defaultValue = "" })

        fun getArgumentsRoute(houseId: String? = null): String {
            val houseId = houseId ?: "{${ARGUMENTS_HOUSE_ID}}"
            return "${TempDone.route}?houseId=$houseId"
        }
    }
}