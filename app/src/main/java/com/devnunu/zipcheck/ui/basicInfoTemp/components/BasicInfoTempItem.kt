package com.devnunu.zipcheck.ui.basicInfoTemp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableRipple
import com.devnunu.zipcheck.common.theme.*

@Composable
fun BasicInfoTempItem(
    key: String,
    value: String? = null,
    maxLines: Int = 1,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickableRipple(
                bounded = true,
                onClick = onClick
            )
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.Top
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            modifier = Modifier.weight(5f),
            style = Medium14,
            text = key,
            color = lightSlate11
        )
        Spacer(modifier = Modifier.width(8.dp))
        val textColor = if (value.isNullOrBlank()) lightRed10 else lightSlate12
        Text(
            modifier = Modifier.weight(9f),
            style = MediumN16,
            text = value ?: "미입력",
            color = textColor,
            maxLines = maxLines,
            textAlign = TextAlign.End,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_mini_right),
            contentDescription = null,
            tint = lightSlate8
        )
        Spacer(modifier = Modifier.width(20.dp))
    }
}