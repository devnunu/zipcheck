package com.devnunu.zipcheck.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.*

@Composable
fun BasicInput(
    modifier: Modifier = Modifier,
    label: String,
    isEssential: Boolean = false,
    value: String?,
    unit: String? = null,
    placeholder: String,
    focusRequester: FocusRequester? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    maxLines: Int = Int.MAX_VALUE,
    maxLength: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
) {
    var isFocused by remember { mutableStateOf(false) }

    val annotatedLabel = buildAnnotatedString {
        append(label)
        if (isEssential) {
            withStyle(style = SpanStyle(color = lightSlate12)) {
                append("*")
            }
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        if (label.isNotEmpty()) {
            Text(
                style = Medium14,
                text = annotatedLabel,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, lightSlate7, RoundedCornerShape(10.dp))
        ) {
            val inputModifier =
                if (focusRequester != null) Modifier.focusRequester(focusRequester) else Modifier
            BasicTextField(
                modifier = inputModifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        isFocused = it.isFocused
                    }
                    .padding(start = 12.dp, end = 12.dp, top = 10.dp, bottom = 10.dp),
                value = value.orEmpty(),
                singleLine = singleLine,
                maxLines = maxLines,
                onValueChange = {
                    if (it.length <= maxLength) {
                        onValueChange(it)
                    }
                },
                textStyle = Regular14,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                cursorBrush = SolidColor(lightMint8),
                decorationBox = { innerTextField ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        if (value.isNullOrBlank()) {
                            Text(
                                style = Regular14,
                                text = placeholder,
                                color = lightSlate9,
                            )
                        }
                    }
                    innerTextField()
                },
                enabled = enabled
            )
            if (unit != null) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.dp),
                    style = Regular14,
                    text = unit,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicInputPreview() {
    BasicInput(
        label = "별칭",
        value = null,
        unit = "제곱미터",
        placeholder = "예) 미래부동산, 010-0000-0000",
        onValueChange = {}
    )
}