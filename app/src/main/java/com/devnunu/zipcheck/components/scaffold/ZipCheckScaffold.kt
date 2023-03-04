package com.devnunu.zipcheck.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ZipCheckScaffold(
    topBar: (@Composable () -> Unit) = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = topBar,
    ) {
        content()
    }
}