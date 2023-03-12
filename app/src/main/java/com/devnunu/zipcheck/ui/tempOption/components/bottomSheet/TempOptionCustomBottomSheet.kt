package com.devnunu.zipcheck.ui.tempOption.components.bottomSheet

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.input.BasicInput

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TempOptionCustomBottomSheet(
    onClickConfirm: (String) -> Unit
) {
    var value by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        BasicInput(
            modifier = Modifier.fillMaxWidth(),
            label = "옵션추가",
            value = value,
            focusRequester = focusRequester,
            placeholder = "추가할 옵션사항을 적어주세요.",
            onValueChange = {
                value = it
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicButton(
            modifier = Modifier.fillMaxWidth(),
            buttonStyle = BtnStyle.PRIMARY_RADIUS,
            buttonSize = BtnSize.LARGE,
            text = "확인",
            onClick = {
                keyboardController?.hide()
                onClickConfirm(value)
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}