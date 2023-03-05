package com.devnunu.zipcheck.ui.basicInfoInput.components.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.components.input.BasicSelector
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.components.input.BasicInput
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun BasicInfoSecondStepView(
    modifier: Modifier = Modifier,
    viewModel: BasicInfoInputViewModel = koinViewModel()
) {

    val state by viewModel.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        BasicSelector(
            label = "집보는 날짜",
            value = "",
            rightIcon = R.drawable.ic_calendar,
            placeholder = "날짜를 입력해주세요",
            onClickSelector = {}
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicInput(
            label = "부동산 정보 메모",
            value = state.memo.orEmpty(),
            placeholder = "예) 미래부동산, 010-0000-0000",
            onValueChange = viewModel::onChangeMemo,
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicInput(
            label = "URL 주소 ",
            value = state.roomInfoUrl.orEmpty(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = "URL 주소를 입력해주세요",
            onValueChange = viewModel::onChangeRoomInfoUrl,
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}