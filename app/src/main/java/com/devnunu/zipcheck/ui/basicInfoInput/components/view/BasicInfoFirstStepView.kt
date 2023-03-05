package com.devnunu.zipcheck.ui.basicInfoInput.components.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.checkBox.CheckBoxText
import com.devnunu.zipcheck.components.input.BasicInput
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel
import com.devnunu.zipcheck.ui.basicInfoInput.components.BasicInfoInputRoomSelector
import com.devnunu.zipcheck.ui.basicInfoInput.components.BasicInfoInputStepIndicator
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
        BasicInfoInputStepIndicator(
            modifier = Modifier.fillMaxWidth(),
            currentPage = state.currentPage
        )
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
            selectedRoomType = state.roomType,
            onClickRoomType = viewModel::onClickRoomType
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicInput(
            label = "집 너비",
            value = (state.roomArea.value).orEmpty(),
            isEssential = true,
            isCursorAlwaysToLastIndex = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = "집 너비를 입력해 주세요",
            unit = state.roomArea.type.typeName,
            singleLine = true,
            onValueChange = viewModel::onChangeRoomArea,
            labelRightContent = {
                BasicButton(
                    buttonStyle = BtnStyle.GRAY_ROUND,
                    buttonSize = BtnSize.SMALL,
                    text = state.roomArea.transformType.typeName,
                    onClick = viewModel::onClickChangeRoomAreaType
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
            isEssential = true,
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
    }
}