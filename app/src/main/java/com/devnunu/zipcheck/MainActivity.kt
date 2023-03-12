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
import com.devnunu.zipcheck.common.theme.ZipCheckTheme
import com.devnunu.zipcheck.ui.basicInfoDone.BasicInfoDoneScreen
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputScreen
import com.devnunu.zipcheck.ui.tempBasicInfo.TempBasicInfoScreen
import com.devnunu.zipcheck.ui.home.HomeScreen
import com.devnunu.zipcheck.ui.tempOption.TempOptionScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

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
                            route = Routes.BasicInfoDone.getArgumentsRoute(),
                            arguments = Routes.BasicInfoDone.arguments
                        ) { backStackEntry ->
                            val houseId = backStackEntry.arguments?.getString(
                                Routes.BasicInfoDone.ARGUMENTS_HOUSE_ID
                            )
                            BasicInfoDoneScreen(
                                houseId = houseId
                            )
                        }
                        composableRightIn(
                            route = Routes.TempBasicInfo.getArgumentsRoute(),
                            arguments = Routes.TempBasicInfo.arguments
                        ) { backStackEntry ->
                            val houseId = backStackEntry.arguments?.getString(
                                Routes.TempBasicInfo.ARGUMENTS_HOUSE_ID
                            )
                            TempBasicInfoScreen(
                                viewModel = koinViewModel(
                                    parameters = { parametersOf(houseId) }
                                )
                            )
                        }
                        composableRightIn(
                            route = Routes.TempOptionInfo.getArgumentsRoute(),
                            arguments = Routes.TempOptionInfo.arguments
                        ) { backStackEntry ->
                            val houseId = backStackEntry.arguments?.getString(
                                Routes.TempOptionInfo.ARGUMENTS_HOUSE_ID
                            )
                            TempOptionScreen(
                                viewModel = koinViewModel(
                                    parameters = { parametersOf(houseId) }
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

