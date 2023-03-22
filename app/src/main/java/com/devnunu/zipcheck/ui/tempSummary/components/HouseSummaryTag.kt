package com.devnunu.zipcheck.ui.tempSummary.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.data.model.house.HouseBenefit

@Composable
fun HouseSummaryTag(
    houseBenefit: HouseBenefit,
    onClickHouseBenefit: (HouseBenefit) -> Unit
) {
    val isSelected = houseBenefit.isSelected
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
    val borderColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            lightMint8
        } else {
            lightSlate7
        },
        animationSpec = tween(
            durationMillis = 300,
        )
    )
    Text(
        modifier = Modifier
            .clickableNonIndication { onClickHouseBenefit(houseBenefit) }
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
            .background(bgColor, RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        style = Medium14,
        text = houseBenefit.text,
        color = textColor
    )
}