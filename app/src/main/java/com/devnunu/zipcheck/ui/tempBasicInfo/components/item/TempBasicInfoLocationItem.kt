package com.devnunu.zipcheck.ui.tempBasicInfo.components.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.*

@Composable
fun TempBasicInfoLocationItem(
    location: String? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickableNonIndication {
                onClick()
            }
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.Top
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            modifier = Modifier.weight(5f),
            style = Medium14,
            text = "집 위치",
            color = lightSlate11
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .weight(9f)
                .height(IntrinsicSize.Min)
                .border(1.dp, lightSlate9, RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.img_map_sample),
                contentDescription = null
            )
            if (location == null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(lightSlate7.copy(alpha = 0.5f), RoundedCornerShape(8.dp)),
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        style = MediumN16,
                        text = "지도에서 \n위치를 설정해주세요",
                        textAlign = TextAlign.Center,
                        color = lightRed10
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(20.dp))
    }
}