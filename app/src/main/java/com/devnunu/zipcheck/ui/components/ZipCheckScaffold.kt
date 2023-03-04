package com.devnunu.zipcheck.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavController
import com.devnunu.zipcheck.common.navigation.LocalNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ZipCheckScaffold(
    content: @Composable () -> Unit
) {
    Scaffold {
        content()
    }
}