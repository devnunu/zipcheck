package com.devnunu.zipcheck.ui.tempBasicInfo.components.bottomSheet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.checkBox.CheckBoxText
import com.devnunu.zipcheck.components.input.BasicInput
import com.devnunu.zipcheck.ui.tempBasicInfo.TempBasicInfoBottomSheetTag

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TempBasicInfoBottomSheet(
    initialValue: String?,
    initialCheckValue: Boolean? = null,
    label: String,
    placeHolder: String,
    checkBoxText: String? = null,
    isNumber: Boolean = false,
    unit: String? = null,
    tag: TempBasicInfoBottomSheetTag,
    onClickSave: (TempBasicInfoBottomSheetTag, String?, Boolean?) -> Unit
) {
    var value by remember { mutableStateOf(initialValue) }
    var checkValue by remember { mutableStateOf(initialCheckValue) }

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        BasicInput(
            label = label,
            value = value,
            placeholder = placeHolder,
            keyboardOptions = KeyboardOptions(
                keyboardType = if (isNumber) KeyboardType.Number else KeyboardType.Text
            ),
            unit = unit,
            focusRequester = focusRequester,
            onValueChange = { str ->
                value = str
            },
            onFocusChanged = { focus ->
                if (focus) {
                    keyboardController?.show()
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (checkBoxText != null) {
            CheckBoxText(
                checked = checkValue ?: false,
                text = checkBoxText,
                onCheckedChange = { checked ->
                    if (checked) {
                        value = null
                    }
                    checkValue = checked
                }
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        BasicButton(
            modifier = Modifier.fillMaxWidth(),
            buttonStyle = BtnStyle.PRIMARY_RADIUS,
            buttonSize = BtnSize.LARGE,
            text = "확인",
            onClick = {
                keyboardController?.hide()
                onClickSave(tag, value, null)
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}