package com.devnunu.zipcheck.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.collectAsState()

    val navController = LocalNavController.current

    ZipCheckScaffold {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
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
                    buttonSize = BtnSize.SMALL,
                    iconRight = R.drawable.ic_add,
                    text = "집 추가하기",
                    onClick = {
                        navController.navigate(Routes.BasicInfoInput.route)
                    }
                )
            }
            Spacer(modifier = Modifier.weight(3f))
        }
    }
}