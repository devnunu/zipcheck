package com.devnunu.zipcheck.ui.basicInfoInput.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.lightMint8
import com.devnunu.zipcheck.common.theme.lightSlate5
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel

@Composable
fun BasicInfoInputStepIndicator(
    modifier: Modifier = Modifier,
    currentPage: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        BasicInfoInputStepIndicatorItem(
            isSelected = currentPage == BasicInfoInputViewModel.PAGE_FIRST
        )
        Spacer(modifier = Modifier.width(8.dp))
        BasicInfoInputStepIndicatorItem(
            isSelected = currentPage == BasicInfoInputViewModel.PAGE_SECOND
        )
    }
}

@Composable
fun BasicInfoInputStepIndicatorItem(
    isSelected: Boolean,
) {
    val color: Color by animateColorAsState(
        targetValue = if (isSelected) {
            lightMint8
        } else {
            lightSlate5
        },
        animationSpec = tween(
            durationMillis = 300,
        )
    )
    Canvas(
        modifier = Modifier
            .size(width = 80.dp, height = 4.dp),
    ) {
        drawRoundRect(
            color = color,
            topLeft = Offset.Zero,
            size = Size(
                width = 80.dp.toPx(),
                height = 4.dp.toPx(),
            ),
            cornerRadius = CornerRadius(
                x = 100.dp.toPx(),
                y = 100.dp.toPx(),
            ),
        )
    }
}