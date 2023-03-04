package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.components.ZipCheckScaffold
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.basicInfoInput.components.BasicInfoInputStepIndicator
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun BasicInfoInputScreen(
    viewModel: BasicInfoInputViewModel = koinViewModel()
) {
    val state by viewModel.collectAsState()

    val navController = LocalNavController.current

    ZipCheckScaffold(
        topBar = {
            TopBar(
                title = "집보러 가기 전 체크 리스트",
                onClickBackBtn = { navController.popBackStack() }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            BasicInfoInputStepIndicator(
                modifier = Modifier.fillMaxWidth(),
                currentPage = state.currentPage
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Hello BasicInfoInputScreen"
            )
        }
    }

}