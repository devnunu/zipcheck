package com.devnunu.zipcheck.ui.basicInfoTemp.components.bottomSheet

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
import com.devnunu.zipcheck.components.checkBox.CheckBoxText
import com.devnunu.zipcheck.components.input.BasicInput
import com.devnunu.zipcheck.ui.basicInfoTemp.BasicInfoTempBottomSheetTag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BasicInfoTempInputBottomSheet(
    initialValue: String?,
    initialCheckValue: Boolean? = null,
    label: String,
    placeHolder: String,
    checkBoxText: String? = null,
    tag: BasicInfoTempBottomSheetTag,
    onClickSave: (BasicInfoTempBottomSheetTag, String?, Boolean?) -> Unit
) {
    var value by remember { mutableStateOf(initialValue) }
    var checkValue by remember { mutableStateOf(initialCheckValue) }

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        BasicInput(
            label = label,
            value = value,
            placeholder = placeHolder,
            focusRequester = focusRequester,
            onValueChange = { str ->
                value = str
            },
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