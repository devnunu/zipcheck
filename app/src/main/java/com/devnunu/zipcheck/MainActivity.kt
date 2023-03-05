package com.devnunu.zipcheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.devnunu.zipcheck.common.ext.composableRightIn
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputScreen
import com.devnunu.zipcheck.ui.home.HomeScreen
import com.devnunu.zipcheck.common.theme.ZipCheckTheme
import com.devnunu.zipcheck.ui.basicInfoDone.BasicInfoDoneScreen
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
                        startDestination = Routes.Home.route
                    ) {
                        composable(
                            route = Routes.Home.route
                        ) {
                            HomeScreen()
                        }
                        composableRightIn(
                            route = Routes.BasicInfoInput.route,
                        ) {
                            BasicInfoInputScreen()
                        }
                        composable(
                            route = Routes.BasicInfoDone.route,
                        ) {
                            BasicInfoDoneScreen()
                        }
                    }
                }
            }
        }
    }
}

