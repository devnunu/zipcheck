package com.devnunu.zipcheck.ui.basicInfoInput.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.components.selector.SelectorDivider
import com.devnunu.zipcheck.components.selector.SelectorItem
import com.devnunu.zipcheck.data.model.HouseType

@Composable
fun BasicInfoInputRoomSelector(
    modifier: Modifier = Modifier,
    label: String,
    selectedHouseType: HouseType,
    onClickHouseType: (HouseType) -> Unit,
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
                isSelected = selectedHouseType == HouseType.TYPE_A,
                text = HouseType.TYPE_A.typeName,
                onClick = { onClickHouseType(HouseType.TYPE_A) }
            )
            SelectorDivider(
                isInvisible = selectedHouseType == HouseType.TYPE_A || selectedHouseType == HouseType.TYPE_B
            )
            SelectorItem(
                modifier = Modifier.weight(1f),
                isSelected = selectedHouseType == HouseType.TYPE_B,
                text = HouseType.TYPE_B.typeName,
                onClick = { onClickHouseType(HouseType.TYPE_B) }
            )
            SelectorDivider(
                isInvisible = selectedHouseType == HouseType.TYPE_B || selectedHouseType == HouseType.TYPE_C
            )
            SelectorItem(
                modifier = Modifier.weight(1f),
                isSelected = selectedHouseType == HouseType.TYPE_C,
                text = HouseType.TYPE_C.typeName,
                onClick = { onClickHouseType(HouseType.TYPE_C) }
            )
            SelectorDivider(
                isInvisible = selectedHouseType == HouseType.TYPE_C || selectedHouseType == HouseType.TYPE_D
            )
            SelectorItem(
                modifier = Modifier.weight(1f),
                isSelected = selectedHouseType == HouseType.TYPE_D,
                text = HouseType.TYPE_D.typeName,
                onClick = { onClickHouseType(HouseType.TYPE_D) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicInfoInputRoomSelectorPreview() {
    BasicInfoInputRoomSelector(
        label = "집 구조",
        selectedHouseType = HouseType.TYPE_A,
        onClickHouseType = {}
    )
}