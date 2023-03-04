package com.devnunu.zipcheck.components.topBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableRipple
import com.devnunu.zipcheck.common.theme.Bold18
import com.devnunu.zipcheck.common.theme.white

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    isShowBackBtn: Boolean = true,
    title: String? = null,
    backBtnIconResourceId: Int = R.drawable.ic_arrow_left,
    onClickBackBtn: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(white)
    ) {
        if (isShowBackBtn) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp, top = 11.dp, bottom = 11.dp)
                    .clickableRipple { onClickBackBtn?.invoke() },
                painter = painterResource(id = backBtnIconResourceId),
                contentDescription = null,
            )
        }
        if (title != null) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                style = Bold18,
                text = title
            )
        }
    }
}