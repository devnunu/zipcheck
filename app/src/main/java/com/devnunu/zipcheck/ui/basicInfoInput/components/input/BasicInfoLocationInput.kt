package com.devnunu.zipcheck.ui.basicInfoInput.components.input

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
import com.devnunu.zipcheck.common.theme.*

@Composable
fun BasicInfoMapInput(
    modifier: Modifier = Modifier,
    label: String,
    location: String? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        if (label.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    style = Medium14,
                    text = label,
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .border(1.dp, lightSlate9, RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth(),
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
                        modifier = modifier.align(Alignment.Center),
                        style = MediumN16,
                        text = "지도에서 \n위치를 설정해주세요",
                        textAlign = TextAlign.Center,
                        color = lightRed10
                    )
                }
            }
        }
    }
}