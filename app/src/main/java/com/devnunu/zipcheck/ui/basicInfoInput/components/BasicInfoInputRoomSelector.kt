package com.devnunu.zipcheck.ui.basicInfoInput.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.applyIf
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.data.RoomType

@Composable
fun BasicInfoInputRoomSelector(
    modifier: Modifier = Modifier,
    label: String,
    selectedRoomType: RoomType,
    onClickRoomType: (RoomType) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            style = Medium14,
            text = label,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .border(1.dp, lightSlate7, RoundedCornerShape(6.dp))
                .clip(RoundedCornerShape(6.dp))
        ) {
            BasicInfoInputRoomSelectorItem(
                modifier = Modifier.weight(1f),
                roomType = RoomType.TYPE_A,
                currentRoomType = selectedRoomType,
                onClick = onClickRoomType
            )
            RoomSelectorVerticalDivider(
                isInvisible = selectedRoomType == RoomType.TYPE_A || selectedRoomType == RoomType.TYPE_B
            )
            BasicInfoInputRoomSelectorItem(
                modifier = Modifier.weight(1f),
                roomType = RoomType.TYPE_B,
                currentRoomType = selectedRoomType,
                onClick = onClickRoomType
            )
            RoomSelectorVerticalDivider(
                isInvisible = selectedRoomType == RoomType.TYPE_B || selectedRoomType == RoomType.TYPE_C
            )
            BasicInfoInputRoomSelectorItem(
                modifier = Modifier.weight(1f),
                roomType = RoomType.TYPE_C,
                currentRoomType = selectedRoomType,
                onClick = onClickRoomType
            )
            RoomSelectorVerticalDivider(
                isInvisible = selectedRoomType == RoomType.TYPE_C || selectedRoomType == RoomType.TYPE_D
            )
            BasicInfoInputRoomSelectorItem(
                modifier = Modifier.weight(1f),
                roomType = RoomType.TYPE_D,
                currentRoomType = selectedRoomType,
                onClick = onClickRoomType
            )
        }
    }
}

@Composable
fun RoomSelectorVerticalDivider(
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

@Composable
fun BasicInfoInputRoomSelectorItem(
    modifier: Modifier = Modifier,
    roomType: RoomType,
    currentRoomType: RoomType,
    onClick: (RoomType) -> Unit
) {
    val isSelected = currentRoomType == roomType
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
            .clickableNonIndication { onClick(roomType) }
            .padding(vertical = 8.dp),
        style = Regular14,
        text = roomType.typeName,
        color = textColor,
        textAlign = TextAlign.Center,
    )
}

@Preview(showBackground = true)
@Composable
fun BasicInfoInputRoomSelectorPreview() {
    BasicInfoInputRoomSelector(
        label = "집 구조",
        selectedRoomType = RoomType.TYPE_A,
        onClickRoomType = {}
    )
}