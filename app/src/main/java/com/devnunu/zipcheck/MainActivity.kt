package com.devnunu.zipcheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.devnunu.zipcheck.common.ext.composableRightIn
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Screen
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputScreen
import com.devnunu.zipcheck.ui.home.HomeScreen
import com.devnunu.zipcheck.common.theme.ZipCheckTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            ZipCheckTheme {
                val navController = rememberAnimatedNavController()
                CompositionLocalProvider(
                    LocalNavController provides navController
                ) {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(
                            route = Screen.Home.route
                        ) {
                            HomeScreen()
                        }
                        composableRightIn(
                            route = Screen.BasicInfoInput.route,
                        ) {
                            BasicInfoInputScreen()
                        }
                    }
                }
            }
        }
    }
}

