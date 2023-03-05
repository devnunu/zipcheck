package com.devnunu.zipcheck.ui.home.components.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.common.theme.BoldN20
import com.devnunu.zipcheck.common.theme.lightSlate10
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle

@Composable
fun HomeEmptyView(
    modifier: Modifier = Modifier,
    onClickAddHouseBtn: () -> Unit
) {

    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                style = BoldN20,
                textAlign = TextAlign.Center,
                text = "집보기 전 \n미리 체크할 것들을 적어보세요"
            )
            Spacer(modifier = Modifier.height(26.dp))
            BasicButton(
                buttonStyle = BtnStyle.PRIMARY_ROUND,
                buttonSize = BtnSize.LARGE,
                iconRight = R.drawable.ic_add,
                text = "집 추가하기",
                onClick = onClickAddHouseBtn
            )
        }
        Spacer(modifier = Modifier.weight(3f))
    }
}