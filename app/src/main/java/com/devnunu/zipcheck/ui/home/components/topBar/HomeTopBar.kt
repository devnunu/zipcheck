package com.devnunu.zipcheck.ui.home.components.topBar

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.theme.lightSlate10
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle

@Composable
fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 15.dp)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            modifier = Modifier.size(51.dp, 26.dp),
            painter = painterResource(id = R.drawable.ic_app_logo_kr),
            contentDescription = null,
            tint = lightSlate10
        )
        Spacer(modifier = Modifier.weight(1f))
        BasicButton(
            buttonStyle = BtnStyle.LINE_ROUND,
            buttonSize = BtnSize.SMALL,
            text = "편집",
            onClick = {}
        )
        Spacer(modifier = Modifier.width(20.dp))
    }
}