package com.devnunu.zipcheck.ui.basicInfoInput.components.input

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
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.components.selector.SelectorDivider
import com.devnunu.zipcheck.components.selector.SelectorItem
import com.devnunu.zipcheck.data.model.RoomType

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
            SelectorItem(
                modifier = Modifier.weight(1f),
                isSelected = selectedRoomType == RoomType.TYPE_A,
                text = RoomType.TYPE_A.typeName,
                onClick = { onClickRoomType(RoomType.TYPE_A) }
            )
            SelectorDivider(
                isInvisible = selectedRoomType == RoomType.TYPE_A || selectedRoomType == RoomType.TYPE_B
            )
            SelectorItem(
                modifier = Modifier.weight(1f),
                isSelected = selectedRoomType == RoomType.TYPE_B,
                text = RoomType.TYPE_B.typeName,
                onClick = { onClickRoomType(RoomType.TYPE_B) }
            )
            SelectorDivider(
                isInvisible = selectedRoomType == RoomType.TYPE_B || selectedRoomType == RoomType.TYPE_C
            )
            SelectorItem(
                modifier = Modifier.weight(1f),
                isSelected = selectedRoomType == RoomType.TYPE_C,
                text = RoomType.TYPE_C.typeName,
                onClick = { onClickRoomType(RoomType.TYPE_C) }
            )
            SelectorDivider(
                isInvisible = selectedRoomType == RoomType.TYPE_C || selectedRoomType == RoomType.TYPE_D
            )
            SelectorItem(
                modifier = Modifier.weight(1f),
                isSelected = selectedRoomType == RoomType.TYPE_D,
                text = RoomType.TYPE_D.typeName,
                onClick = { onClickRoomType(RoomType.TYPE_D) }
            )
        }
    }
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