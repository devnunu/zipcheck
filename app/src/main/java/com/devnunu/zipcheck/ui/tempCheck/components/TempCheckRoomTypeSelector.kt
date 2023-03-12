package com.devnunu.zipcheck.ui.tempCheck.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.Medium12
import com.devnunu.zipcheck.common.theme.lightSlate11
import com.devnunu.zipcheck.common.theme.lightSlate3
import com.devnunu.zipcheck.common.theme.white
import com.devnunu.zipcheck.data.model.RoomTypeChecklist

@Composable
fun TempCheckRoomTypeSelector(
    roomTypeList: List<RoomTypeChecklist>,
    selectedCheckList: RoomTypeChecklist?,
    onClickRoomType: (RoomTypeChecklist) -> Unit
) {
    Row {
        roomTypeList.forEachIndexed { index, roomType ->
            if (index != 0) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            TempCheckRoomTypeSelectorItem(
                roomType = roomType,
                isSelected = selectedCheckList?.name == roomType.name,
                onClickRoomType = onClickRoomType
            )
        }
    }
}

@Composable
fun TempCheckRoomTypeSelectorItem(
    roomType: RoomTypeChecklist,
    isSelected: Boolean,
    onClickRoomType: (RoomTypeChecklist) -> Unit
) {
    val bgColor = if (isSelected) lightSlate11 else lightSlate3
    val textColor = if (isSelected) white else lightSlate11
    Text(
        modifier = Modifier
            .clickableNonIndication { onClickRoomType(roomType) }
            .background(bgColor, RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp),
        style = Medium12,
        text = roomType.name,
        color = textColor
    )
}