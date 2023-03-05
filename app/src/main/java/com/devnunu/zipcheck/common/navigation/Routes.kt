package com.devnunu.zipcheck.common.navigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object BasicInfoInput : Routes("basicInfo/input")
    object BasicInfoDone : Routes("basicInfo/done")
}