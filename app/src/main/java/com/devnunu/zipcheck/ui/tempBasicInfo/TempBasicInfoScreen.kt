package com.devnunu.zipcheck.ui.tempBasicInfo

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
import com.devnunu.zipcheck.ui.tempBasicInfo.components.item.TempBasicInfoItem
import com.devnunu.zipcheck.ui.tempBasicInfo.components.item.TempBasicInfoLocationItem
import com.devnunu.zipcheck.ui.tempBasicInfo.components.bottomSheet.TempBasicInfoBottomSheet
import com.devnunu.zipcheck.ui.tempBasicInfo.components.bottomSheet.TempBasicInfoRoomTypeBottomSheet
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun TempBasicInfoScreen(
    viewModel: TempBasicInfoViewModel
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
                TempBasicInfoBottomSheetTag.ALIAS -> {
                    TempBasicInfoBottomSheet(
                        initialValue = house?.alias,
                        label = "별칭",
                        placeHolder = "별칭을 입력해주세요",
                        tag = TempBasicInfoBottomSheetTag.ALIAS,
                        onClickSave = viewModel::onClickInputBottomSheetSaveBtn
                    )
                }
                TempBasicInfoBottomSheetTag.VISIT_DATE -> Unit
                TempBasicInfoBottomSheetTag.LOCATION -> Unit
                TempBasicInfoBottomSheetTag.MEMO -> {
                    TempBasicInfoBottomSheet(
                        initialValue = house?.memo,
                        label = "메모",
                        placeHolder = "메모를 입력해주세요",
                        tag = TempBasicInfoBottomSheetTag.MEMO,
                        onClickSave = viewModel::onClickInputBottomSheetSaveBtn
                    )
                }
                TempBasicInfoBottomSheetTag.ROOM_INFO_URL -> {
                    TempBasicInfoBottomSheet(
                        initialValue = house?.memo,
                        label = "URL 주소",
                        placeHolder = "URL 주소를 입력해주세요",
                        tag = TempBasicInfoBottomSheetTag.ROOM_INFO_URL,
                        onClickSave = viewModel::onClickInputBottomSheetSaveBtn
                    )
                }
                TempBasicInfoBottomSheetTag.ROOM_TYPE -> {
                    TempBasicInfoRoomTypeBottomSheet(
                        onClickRoomType = viewModel::onClickRoomType
                    )
                }
                TempBasicInfoBottomSheetTag.ROOM_AREA -> {

                }
                TempBasicInfoBottomSheetTag.DEPOSIT_AMOUNT -> {
                    TempBasicInfoBottomSheet(
                        initialValue = house?.depositAmount?.toString().orEmpty(),
                        label = "보증금",
                        placeHolder = "보증금을 입력해주세요",
                        tag = TempBasicInfoBottomSheetTag.DEPOSIT_AMOUNT,
                        isNumber = true,
                        unit = "만원",
                        onClickSave = viewModel::onClickInputBottomSheetSaveBtn
                    )
                }
                TempBasicInfoBottomSheetTag.MONTHLY_AMOUNT -> {
                    TempBasicInfoBottomSheet(
                        initialValue = house?.monthlyAmount?.toString().orEmpty(),
                        initialCheckValue = house?.isNoMonthlyAmount,
                        label = "월세",
                        placeHolder = "월세를 입력해주세요",
                        checkBoxText = "월세 없음",
                        tag = TempBasicInfoBottomSheetTag.MONTHLY_AMOUNT,
                        isNumber = true,
                        unit = "만원",
                        onClickSave = viewModel::onClickInputBottomSheetSaveBtn
                    )
                }
                TempBasicInfoBottomSheetTag.MAINTENANCE_COST -> {
                    TempBasicInfoBottomSheet(
                        initialValue = house?.maintenanceCost?.toString().orEmpty(),
                        initialCheckValue = house?.isNoMaintenanceCost,
                        label = "관리비",
                        placeHolder = "관리비를 입력해주세요",
                        checkBoxText = "관리비 없음",
                        tag = TempBasicInfoBottomSheetTag.MAINTENANCE_COST,
                        isNumber = true,
                        unit = "만원",
                        onClickSave = viewModel::onClickInputBottomSheetSaveBtn
                    )
                }
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
                TempBasicInfoItem(
                    key = "별칭",
                    value = house?.alias,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.ALIAS)
                    }
                )
                TempBasicInfoItem(
                    key = "집보는 날짜",
                    value = null,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.VISIT_DATE)
                    }
                )
                TempBasicInfoLocationItem(
                    location = null,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.LOCATION)
                    }
                )
                TempBasicInfoItem(
                    key = "부동산 정보 메모",
                    value = house?.memo,
                    maxLines = 2,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.MEMO)
                    }
                )
                TempBasicInfoItem(
                    key = "URL 주소",
                    value = house?.roomInfoUrl,
                    maxLines = 2,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.ROOM_INFO_URL)
                    }
                )
                TempBasicInfoItem(
                    key = "집구조",
                    value = house?.roomType?.typeName,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.ROOM_TYPE)
                    }
                )
                val roomArea = if (house?.roomArea?.value != null) {
                    "${house.roomArea.value} ${house.roomArea.type.typeName}"
                } else {
                    null
                }
                TempBasicInfoItem(
                    key = "집너비",
                    value = roomArea,
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.ROOM_AREA)
                    }
                )
                TempBasicInfoItem(
                    key = "보증금",
                    value = house?.depositAmount?.toKrCurrencyFullText(true),
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.DEPOSIT_AMOUNT)
                    }
                )
                TempBasicInfoItem(
                    key = "월세",
                    value = house?.monthlyAmount?.toKrCurrencyFullText(true),
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.MONTHLY_AMOUNT)
                    }
                )
                TempBasicInfoItem(
                    key = "관리비",
                    value = house?.maintenanceCost?.toKrCurrencyFullText(true),
                    onClick = {
                        viewModel.onClickOpenBottomSheet(TempBasicInfoBottomSheetTag.MAINTENANCE_COST)
                    }
                )
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}