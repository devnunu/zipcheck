package com.devnunu.zipcheck.ui.basicInfoInput.components.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.checkBox.CheckBoxText
import com.devnunu.zipcheck.components.input.BasicInput
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel
import com.devnunu.zipcheck.ui.basicInfoInput.components.input.BasicInfoInputRoomSelector
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun BasicInfoFirstStepView(
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
        BasicInput(
            label = "별칭",
            value = state.alias,
            placeholder = "별칭을 입력해주세요",
            onValueChange = viewModel::onChangeAlias,
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicInfoInputRoomSelector(
            label = "집 구조",
            selectedHouseType = state.houseType,
            onClickHouseType = viewModel::onClickHouseType
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicInput(
            label = "집 너비",
            value = (state.houseArea.value).orEmpty(),
            isEssential = true,
            isCursorAlwaysToLastIndex = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = "집 너비를 입력해 주세요",
            unit = state.houseArea.type?.typeName,
            singleLine = true,
            onValueChange = viewModel::onChangeHouseArea,
            labelRightContent = {
                BasicButton(
                    buttonStyle = BtnStyle.GRAY_ROUND,
                    buttonSize = BtnSize.SMALL,
                    text = state.houseArea.transformType.typeName,
                    onClick = viewModel::onClickChangeHouseAreaType
                )
            },
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicInput(
            label = "전/월세 보증금",
            value = state.depositAmount?.toString().orEmpty(),
            isEssential = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = "보증금을 입력해주세요",
            unit = "만원",
            singleLine = true,
            onValueChange = viewModel::onChangeDepositAmount,
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicInput(
            label = "월세",
            value = state.monthlyAmount?.toString().orEmpty(),
            isEssential = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = "월세를 입력해주세요",
            unit = "만원",
            singleLine = true,
            enabled = !state.isNoMonthlyAmount,
            onValueChange = viewModel::onChangeMonthlyAmount,
        )
        Spacer(modifier = Modifier.height(10.dp))
        CheckBoxText(
            checked = state.isNoMonthlyAmount,
            text = "월세 없음",
            onCheckedChange = viewModel::onClickNoMonthlyAmount
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicInput(
            label = "관리비",
            value = state.maintenanceCost?.toString().orEmpty(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = "관리비를 입력해주세요",
            unit = "만원",
            singleLine = true,
            enabled = !state.isNoMaintenanceCost,
            onValueChange = viewModel::onChangeMaintenanceCost,
        )
        Spacer(modifier = Modifier.height(10.dp))
        CheckBoxText(
            checked = state.isNoMaintenanceCost,
            text = "관리비 없음",
            onCheckedChange = viewModel::onClickNoMaintenanceCost,
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}