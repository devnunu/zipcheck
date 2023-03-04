package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.basicInfoInput.components.view.BasicInfoFirstStepView
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
        },
        bottomBar = {
            BasicButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 12.dp),
                buttonStyle = BtnStyle.PRIMARY_RADIUS,
                buttonSize = BtnSize.LARGE,
                text = "다음",
                onClick = {}
            )
        }
    ) { paddingValues ->
        BasicInfoFirstStepView(
            modifier = Modifier.padding(
                bottom = paddingValues.calculateBottomPadding()
            )
        )
    }
}