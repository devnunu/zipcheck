package com.devnunu.zipcheck.components.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.*

@Composable
fun BasicInput(
    modifier: Modifier = Modifier,
    label: String,
    isEssential: Boolean = false,
    isCursorAlwaysToLastIndex: Boolean = false,
    value: String?,
    unit: String? = null,
    placeholder: String,
    errorText: String? = null,
    focusRequester: FocusRequester? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    maxLines: Int = Int.MAX_VALUE,
    maxLength: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    enabled: Boolean = true,
    labelRightContent: (@Composable () -> Unit)? = null,
    onFocusChanged: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit,
) {
    var isFocused by remember { mutableStateOf(false) }

    val annotatedLabel = buildAnnotatedString {
        append(label)
        if (isEssential) {
            withStyle(style = SpanStyle(color = lightRed10)) {
                append(" *")
            }
        }
    }

    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value.orEmpty())) }
    val textFieldValue = textFieldValueState.copy(
        text = value.orEmpty(),
        selection = if (isCursorAlwaysToLastIndex) {
            TextRange(index = value.orEmpty().length)
        } else {
            TextRange.Zero
        }
    )

    LaunchedEffect(isFocused) {
        onFocusChanged(isFocused)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        if (label.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    style = Medium14,
                    text = annotatedLabel,
                )
                if (labelRightContent != null) {
                    Spacer(modifier = Modifier.weight(1f))
                    labelRightContent()
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        val borderColor: Color by animateColorAsState(
            targetValue = when {
                errorText != null -> lightRed10
                isFocused -> lightGreen9
                else -> lightSlate7
            },
            animationSpec = tween(
                durationMillis = 300,
            )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, borderColor, RoundedCornerShape(10.dp))
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
                value = textFieldValue,
                singleLine = singleLine,
                maxLines = maxLines,
                onValueChange = {
                    if (it.text.length <= maxLength) {
                        textFieldValueState = it
                        onValueChange(it.text)
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