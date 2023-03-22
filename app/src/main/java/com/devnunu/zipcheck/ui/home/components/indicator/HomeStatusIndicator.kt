package com.devnunu.zipcheck.ui.home.components.indicator

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.data.model.house.HouseWriteStatus

@Composable
fun HomeStatusIndicator(
    modifier: Modifier = Modifier,
    currentSortStatus: HouseWriteStatus,
    onClickIndicator: (HouseWriteStatus) -> Unit
) {
    Row(
        modifier = modifier
            .border(1.dp, lightSlate7, RoundedCornerShape(50.dp))
            .background(lightSlate3, RoundedCornerShape(50.dp))
            .clip(RoundedCornerShape(50.dp))
            .padding(4.dp)
    ) {
        HomeStatusIndicatorItem(
            "작성중인 집",
            isSelected = currentSortStatus == HouseWriteStatus.IN_PROGRESS,
            onClick = { onClickIndicator(HouseWriteStatus.IN_PROGRESS) }
        )
        HomeStatusIndicatorItem(
            "탈락한 집",
            isSelected = currentSortStatus == HouseWriteStatus.FAIL,
            onClick = { onClickIndicator(HouseWriteStatus.FAIL) }
        )
    }
}

@Composable
fun HomeStatusIndicatorItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val bgColor = if (isSelected) {
        white
    } else {
        transparent
    }

    val textColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            lightSlate12
        } else {
            lightSlate9
        },
        animationSpec = tween(
            durationMillis = 300,
        )
    )

    val textStyle = if (isSelected) {
        Bold14
    } else {
        Medium14
    }

    Text(
        modifier = Modifier
            .clickableNonIndication { onClick() }
            .background(bgColor, RoundedCornerShape(50.dp))
            .padding(horizontal = 16.dp, vertical = 10.dp),
        style = textStyle,
        text = text,
        color = textColor
    )
}