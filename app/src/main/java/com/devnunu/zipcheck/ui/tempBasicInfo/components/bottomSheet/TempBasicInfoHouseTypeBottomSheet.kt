package com.devnunu.zipcheck.ui.tempBasicInfo.components.bottomSheet

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.clickableRipple
import com.devnunu.zipcheck.data.model.house.HouseType

@Composable
fun TempBasicInfoHouseTypeBottomSheet(
    onClickHouseType: (HouseType) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        HouseType.values().forEach { houseType ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickableRipple(
                        bounded = true,
                        onClick = {
                            onClickHouseType(houseType)
                        }
                    )
                    .padding(vertical = 20.dp, horizontal = 24.dp),
                text = houseType.typeName
            )
        }
    }
}