package com.devnunu.zipcheck.components.checkBox

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.Regular16

@Composable
fun CheckBoxText(
    modifier: Modifier = Modifier,
    checked: Boolean,
    text: String,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(modifier = modifier) {
        ZipCheckCheckBox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            style = Regular16,
            text = text
        )
    }
}

@Preview(
    showBackground = true,
    name = "checked"
)
@Composable
fun CheckBoxTextPreview1() {
    CheckBoxText(
        checked = true,
        text = "채광이 잘들어요",
        onCheckedChange = {}
    )
}

@Preview(
    showBackground = true,
    name = "unchecked"
)
@Composable
fun CheckBoxTextPreview2() {
    CheckBoxText(
        checked = false,
        text = "크기가 적당해요",
        onCheckedChange = {}
    )
}