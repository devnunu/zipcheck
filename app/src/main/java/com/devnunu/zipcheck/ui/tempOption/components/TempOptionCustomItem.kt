package com.devnunu.zipcheck.ui.tempOption.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.*

@Composable
fun TempOptionCustomItem(
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickableNonIndication { onClick() }
                .border(1.dp, lightSlate6, RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(36.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = null,
                    tint = lightSlate8
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    style = Medium12,
                    text = "직접입력",
                    color = lightSlate10
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_tooltip_arrow_up),
            contentDescription = null,
            tint = lightSlate11
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(lightSlate11, RoundedCornerShape(8.dp))
                .padding(horizontal = 10.dp, vertical = 8.dp),
            style = MediumN12,
            text = "옵션을 직접 \n추가할 수 있어요",
            color = white,
            textAlign = TextAlign.Center
        )
    }
}