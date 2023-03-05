package com.devnunu.zipcheck.ui.home.components.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableRipple
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.data.model.House

@Composable
fun HouseItem(
    house: House,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickableRipple(
                bounded = true,
                onClick = { onClick(house.id) }
            )
            .padding(vertical = 18.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(52.dp),
            painter = painterResource(id = R.drawable.ic_house_purple),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                style = Regular12,
                text = "2023.01.23 방문",
                color = lightSlate9
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                style = Bold16,
                text = "3층집 꼭대기층",
                color = lightSlate12
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                style = Medium14,
                text = "보증금 1000 / 월 50",
                color = lightSlate11
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_mini_right),
            contentDescription = null,
            tint = lightSlate8
        )
    }
}