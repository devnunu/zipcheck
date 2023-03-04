package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.components.ZipCheckScaffold
import com.devnunu.zipcheck.components.input.BasicInput
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.basicInfoInput.components.BasicInfoInputRoomSelector
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
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            BasicInfoInputStepIndicator(
                modifier = Modifier.fillMaxWidth(),
                currentPage = state.currentPage
            )
            Spacer(modifier = Modifier.height(30.dp))
            BasicInput(
                label = "별칭",
                value = state.alias,
                placeholder = "별칭을 입력해주세요",
                onValueChange = viewModel::onChangeAlias
            )
            Spacer(modifier = Modifier.height(30.dp))
            BasicInfoInputRoomSelector(
                label = "집 구조",
                selectedRoomType = state.roomType,
                onClickRoomType = viewModel::onClickRoomType
            )
        }
    }
}