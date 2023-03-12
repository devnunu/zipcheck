package com.devnunu.zipcheck.ui.tempOption

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.common.theme.Bold20
import com.devnunu.zipcheck.components.bottomSheet.rememberScaffoldBottomSheetView
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.tempOption.components.TempOptionCustomItem
import com.devnunu.zipcheck.ui.tempOption.components.item.TempOptionItem
import com.devnunu.zipcheck.ui.tempOption.components.bottomSheet.TempOptionCustomBottomSheet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun TempOptionScreen(
    viewModel: TempOptionViewModel
) {

    val state by viewModel.collectAsState()
    val viewModelSheetState = state.bottomSheetState

    val house = state.house
    val houseOptionList = state.houseOptionList

    val navController = LocalNavController.current
    val scope: CoroutineScope = rememberCoroutineScope()

    ZipCheckScaffold(
        topBar = {
            TopBar(
                title = "옵션",
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
                onClick = {
                    viewModel.onClickNextBtn(
                        onSuccess = {
                            scope.launch {
                                navController.navigate(
                                    Routes.TempSummary.getArgumentsRoute(
                                        house?.id
                                    )
                                )
                            }
                        }
                    )
                }
            )
        },
        bottomSheetView = rememberScaffoldBottomSheetView(
            viewModelSheetState = viewModelSheetState,
            onCloseBottomSheet = viewModel::onCloseBottomSheet
        ) {
            when (viewModelSheetState.tag) {
                TempOptionBottomSheetTag.OPTION -> {
                    TempOptionCustomBottomSheet(
                        onClickConfirm = viewModel::onClickCustomOptionConfirmBtn
                    )
                }
                else -> Unit
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                style = Bold20,
                text = "어떤 옵션들이 있나요?"
            )
            Spacer(modifier = Modifier.height(34.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(houseOptionList) { houseOption ->
                    TempOptionItem(
                        houseOption = houseOption,
                        onClickItem = {
                            viewModel.onClickItem(houseOption)
                        },
                        onDeleteCustomOption = {
                            viewModel.onDeleteCustomOption(houseOption)
                        }
                    )
                }
                item {
                    TempOptionCustomItem(
                        onClick = {
                            viewModel.onClickOpenBottomSheet(TempOptionBottomSheetTag.OPTION)
                        }
                    )
                }
            }
        }
    }
}