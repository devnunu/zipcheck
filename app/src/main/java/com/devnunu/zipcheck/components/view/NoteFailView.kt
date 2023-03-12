package com.devnunu.zipcheck.components.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.*

@Composable
fun NoteFailView(
    onClickChangeToFailText: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, lightSlate6, RoundedCornerShape(10.dp))
            .padding(top = 14.dp, bottom = 14.dp, start = 18.dp, end = 25.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_warning),
            contentDescription = null,
            tint = lightSlate8
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                style = Bold12,
                text = "혹시 이 집이 별로라면 바로 탈락 리스트로 옮겨보세요.",
                color = lightSlate11
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                modifier = Modifier.clickableNonIndication {
                    onClickChangeToFailText()
                },
                style = Regular12,
                text = "탈락 리스트로 옮기기",
                color = lightSlate9,
                textDecoration = TextDecoration.Underline,
            )
        }
    }
}