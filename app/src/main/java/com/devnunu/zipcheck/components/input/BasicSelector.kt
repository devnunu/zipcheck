package com.devnunu.zipcheck.components.input

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableNonIndication

@Composable
fun BasicSelector(
    modifier: Modifier = Modifier,
    label: String,
    isEssential: Boolean = false,
    value: String?,
    @DrawableRes rightIcon: Int? = null,
    placeholder: String,
    onClickSelector: () -> Unit,
) {

    val annotatedLabel = buildAnnotatedString {
        append(label)
        if (isEssential) {
            withStyle(style = SpanStyle(color = lightRed10)) {
                append(" *")
            }
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        if (label.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    style = Medium14,
                    text = annotatedLabel,
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickableNonIndication { onClickSelector() }
                .border(1.dp, lightSlate7, RoundedCornerShape(10.dp))
                .padding(start = 12.dp, end = 12.dp, top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val textColor = if (value.isNullOrBlank()) lightSlate9 else lightSlate12
            val text = if(value.isNullOrBlank()) placeholder else value
            Text(
                modifier = Modifier.weight(1f),
                style = Regular14,
                color = textColor,
                text = text
            )
            if (rightIcon != null) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = null,
                    tint = lightSlate9
                )
            }
        }
    }
}