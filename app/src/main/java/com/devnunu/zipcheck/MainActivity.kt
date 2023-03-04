package com.devnunu.zipcheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Screen
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputScreen
import com.devnunu.zipcheck.ui.home.HomeScreen
import com.devnunu.zipcheck.common.theme.ZipCheckTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            ZipCheckTheme {
                val navController = rememberNavController()
                CompositionLocalProvider(
                    LocalNavController provides navController
                ) {
                    NavHost(navController = navController, startDestination = Screen.Home.route) {
                        composable(Screen.Home.route) { HomeScreen() }
                        composable(Screen.BasicInfoInput.route) { BasicInfoInputScreen() }
                    }
                }
            }
        }
    }
}

