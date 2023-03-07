package com.devnunu.zipcheck.components.scaffold

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.components.bottomSheet.BottomSheetState

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun rememberScaffoldBottomSheetView(
    viewModelSheetState: BottomSheetState<*>,
    onCloseBottomSheet: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
): ScaffoldBottomSheetView {
    val modalBottomSheetState = rememberBottomSheetState(
        onDismissBottomSheet = onCloseBottomSheet
    )
    val isKeyboardOpened = WindowInsets.isImeVisible
    return ScaffoldBottomSheetView(
        viewModelSheetState = viewModelSheetState,
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
    ) {
        CZBottomSheetWrapper(
            modalBottomSheetState = modalBottomSheetState,
            onClickBack = {
                if(!isKeyboardOpened) {
                    onCloseBottomSheet()
                }
            }
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun rememberBottomSheetState(
    onDismissBottomSheet: () -> Unit
) = rememberModalBottomSheetState(
    initialValue = ModalBottomSheetValue.Hidden,
    skipHalfExpanded = true,
    confirmValueChange = {
        if (it == ModalBottomSheetValue.Hidden) {
            onDismissBottomSheet()
            return@rememberModalBottomSheetState true
        }
        if (it == ModalBottomSheetValue.HalfExpanded) {
            return@rememberModalBottomSheetState false
        }
        true
    })

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CZBottomSheetWrapper(
    modalBottomSheetState: ModalBottomSheetState,
    onClickBack: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.padding(top = 1.dp)
    ) {
        content()
        BackHandler(
            enabled = modalBottomSheetState.isVisible,
            onBack = onClickBack
        )
    }
}

