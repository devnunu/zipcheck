package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.applyIf
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.checkBox.CheckBoxText
import com.devnunu.zipcheck.components.input.BasicInput
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.basicInfoInput.components.BasicInfoInputRoomSelector
import com.devnunu.zipcheck.ui.basicInfoInput.components.BasicInfoInputStepIndicator
import com.devnunu.zipcheck.ui.basicInfoInput.components.view.BasicInfoFirstStepView
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@OptIn(ExperimentalLayoutApi::class)
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