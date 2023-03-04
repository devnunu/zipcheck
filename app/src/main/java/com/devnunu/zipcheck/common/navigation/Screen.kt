package com.devnunu.zipcheck.common.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Temp : Screen("temp")
}