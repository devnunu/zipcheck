package com.devnunu.zipcheck.ui.tempBasicInfo.components.bottomSheet

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.clickableRipple
import com.devnunu.zipcheck.data.model.RoomType

@Composable
fun TempBasicInfoRoomTypeBottomSheet(
    onClickRoomType: (RoomType) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        RoomType.values().forEach { roomType ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickableRipple(
                        bounded = true,
                        onClick = {
                            onClickRoomType(roomType)
                        }
                    )
                    .padding(vertical = 20.dp, horizontal = 24.dp),
                text = roomType.typeName
            )
        }
    }
}