package com.devnunu.zipcheck.ui.basicInfoTemp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.toKrCurrencyFullText
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.theme.BoldN20
import com.devnunu.zipcheck.common.theme.lightSlate3
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.bottomSheet.rememberScaffoldBottomSheetView
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.basicInfoTemp.components.item.BasicInfoTempItem
import com.devnunu.zipcheck.ui.basicInfoTemp.components.item.BasicInfoTempLocationItem
import com.devnunu.zipcheck.ui.basicInfoTemp.components.bottomSheet.BasicInfoTempInputBottomSheet
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun BasicInfoTempScreen(
    viewModel: BasicInfoTempViewModel
) {
    val state by viewModel.collectAsState()
    val house = state.house

    val viewModelSheetState = state.bottomSheetState

    val navController = LocalNavController.current

    ZipCheckScaffold(
        topBar = {
            TopBar(
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
        },
        bottomSheetView = rememberScaffoldBottomSheetView(
            viewModelSheetState = viewModelSheetState,
            onCloseBottomSheet = viewModel::onCloseBottomSheet
        ) {
            when (viewModelSheetState.tag) {
                BasicInfoTempBottomSheetTag.ALIAS -> {
                    BasicInfoTempInputBottomSheet(
                        initialValue = house?.alias,
                        label = "별칭",
                        placeHolder = "별칭을 입력해주세요",
                        tag = BasicInfoTempBottomSheetTag.ALIAS,
                        onClickSave = viewModel::onClickInputBottomSheetSaveBtn
                    )
                }
                BasicInfoTempBottomSheetTag.VISIT_DATE -> Unit
                BasicInfoTempBottomSheetTag.LOCATION -> Unit
                BasicInfoTempBottomSheetTag.MEMO -> Unit
                BasicInfoTempBottomSheetTag.ROOM_TYPE -> Unit
                BasicInfoTempBottomSheetTag.ROOM_INFO_URL -> Unit
                BasicInfoTempBottomSheetTag.ROOM_AREA -> Unit
                BasicInfoTempBottomSheetTag.DEPOSIT_AMOUNT -> Unit
                BasicInfoTempBottomSheetTag.MONTHLY_AMOUNT -> Unit
                BasicInfoTempBottomSheetTag.MAINTENANCE_AMOUNT -> Unit
                else -> Unit
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                style = BoldN20,
                text = "작성중인 내용을 확인하고\n이어서 작성해주세요."
            )
            Spacer(modifier = Modifier.height(20.dp))
            Divider(
                color = lightSlate3,
                thickness = 8.dp
            )
            Column {
                Spacer(modifier = Modifier.height(24.dp))
                BasicInfoTempItem(
                    key = "별칭",
                    value = house?.alias,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.ALIAS)
                    }
                )
                BasicInfoTempItem(
                    key = "집보는 날짜",
                    value = null,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.VISIT_DATE)
                    }
                )
                BasicInfoTempLocationItem(
                    location = null,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.LOCATION)
                    }
                )
                BasicInfoTempItem(
                    key = "부동산 정보 메모",
                    value = house?.memo,
                    maxLines = 2,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.MEMO)
                    }
                )
                BasicInfoTempItem(
                    key = "URL 주소",
                    value = house?.roomInfoUrl,
                    maxLines = 2,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.ROOM_INFO_URL)
                    }
                )
                BasicInfoTempItem(
                    key = "집구조",
                    value = house?.roomType?.typeName,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.ROOM_TYPE)
                    }
                )
                val roomArea = if (house?.roomArea?.value != null) {
                    "${house.roomArea.value} ${house.roomArea.type.typeName}"
                } else {
                    null
                }
                BasicInfoTempItem(
                    key = "집너비",
                    value = roomArea,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.ROOM_AREA)
                    }
                )
                BasicInfoTempItem(
                    key = "보증금",
                    value = house?.depositAmount?.toKrCurrencyFullText(true),
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.DEPOSIT_AMOUNT)
                    }
                )
                BasicInfoTempItem(
                    key = "월세",
                    value = house?.monthlyAmount?.toKrCurrencyFullText(true),
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.MONTHLY_AMOUNT)
                    }
                )
                BasicInfoTempItem(
                    key = "관리비",
                    value = house?.maintenanceCost?.toKrCurrencyFullText(true),
                    onClick = {
                        viewModel.onClickOpenBottomSheet(BasicInfoTempBottomSheetTag.MAINTENANCE_AMOUNT)
                    }
                )
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}