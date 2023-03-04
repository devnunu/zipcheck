package com.devnunu.zipcheck.components

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ZipCheckScaffold(
    content: @Composable () -> Unit
) {
    Scaffold {
        content()
    }
}