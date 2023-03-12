package com.devnunu.zipcheck.components.selector

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.lightSlate7

@Composable
fun SelectorDivider(
    isInvisible: Boolean
) {
    val alpha: Float by animateFloatAsState(
        targetValue = if (isInvisible) {
            0f
        } else {
            1f
        },
        animationSpec = tween(
            durationMillis = 300,
        )
    )
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .padding(vertical = 4.dp)
            .alpha(alpha),
        color = lightSlate7
    )
}
