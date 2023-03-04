package com.devnunu.zipcheck.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Screen
import com.devnunu.zipcheck.components.ZipCheckScaffold
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.collectAsState()

    val navController = LocalNavController.current

    ZipCheckScaffold {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_app_logo_kr),
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            
        }
        Text(
            modifier = Modifier.clickable {
                navController.navigate(Screen.BasicInfoInput.route)
            },
            text = "Hello ${state.title}!"
        )
    }
}