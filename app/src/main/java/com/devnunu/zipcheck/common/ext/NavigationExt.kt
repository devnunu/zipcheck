package com.devnunu.zipcheck.common.ext

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.composableRightIn(
    route: String,
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left) },
        popExitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right) },
        content = content
    )
}

fun NavController.navigateWithPopUp(
    toRoute: String,
    fromRoute: String
) {
    this.navigate(toRoute) {
        popUpTo(fromRoute) {
            inclusive = true
        }
    }
}