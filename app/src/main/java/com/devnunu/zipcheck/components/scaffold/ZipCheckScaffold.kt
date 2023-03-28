package com.devnunu.zipcheck.components.scaffold

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import com.devnunu.zipcheck.components.bottomSheet.BottomSheetState
import com.devnunu.zipcheck.ui.components.ToastViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged

@OptIn(ExperimentalMaterialApi::class)
data class ScaffoldBottomSheetView(
    val viewModelSheetState: BottomSheetState<*>,
    val sheetState: ModalBottomSheetState,
    val sheetShape: Shape,
    val sheetContent: @Composable ColumnScope.() -> Unit,
)

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ZipCheckScaffold(
    topBar: (@Composable () -> Unit) = {},
    bottomBar: @Composable () -> Unit = {},
    bottomSheetView: ScaffoldBottomSheetView? = null,
    toastViewModel: ToastViewModel? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    val child = @Composable {
        Scaffold(
            topBar = topBar,
            bottomBar = bottomBar
        ) {
            content(it)
        }
    }

    if (toastViewModel != null) {
        val context = LocalContext.current
        LaunchedEffect(Unit) {
            toastViewModel.toastMessage
                .collect { message ->
                    Toast.makeText(
                        context,
                        message,
                        Toast.LENGTH_SHORT,
                    ).show()
                }
        }
    }
    if (bottomSheetView != null) {
        LaunchedEffect(bottomSheetView) {
            snapshotFlow { bottomSheetView.viewModelSheetState }
                .distinctUntilChanged()
                .collect { viewModelSheetState ->
                    when (viewModelSheetState) {
                        is BottomSheetState.Closed -> bottomSheetView.sheetState.animateTo(
                            ModalBottomSheetValue.Hidden
                        )
                        is BottomSheetState.Opened -> bottomSheetView.sheetState.animateTo(
                            ModalBottomSheetValue.Expanded
                        )
                    }
                }
        }
        ModalBottomSheetLayout(
            sheetState = bottomSheetView.sheetState,
            sheetShape = bottomSheetView.sheetShape,
            sheetContent = bottomSheetView.sheetContent,
            content = {
                child()
            }
        )
    } else {
        child()
    }
}