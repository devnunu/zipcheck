package com.devnunu.zipcheck.components.selector

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.Regular14
import com.devnunu.zipcheck.common.theme.lightMint8
import com.devnunu.zipcheck.common.theme.lightSlate9
import com.devnunu.zipcheck.common.theme.white
import com.devnunu.zipcheck.data.model.RoomType

@Composable
fun SelectorItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    text: String,
    onClick: () -> Unit
) {
    val bgColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            lightMint8
        } else {
            white
        },
        animationSpec = tween(
            durationMillis = 300,
        )
    )
    val textColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            white
        } else {
            lightSlate9
        },
        animationSpec = tween(
            durationMillis = 300,
        )
    )
    Text(
        modifier = modifier
            .background(bgColor)
            .clickableNonIndication { onClick() }
            .padding(vertical = 8.dp),
        style = Regular14,
        text = text,
        color = textColor,
        textAlign = TextAlign.Center,
    )
}
