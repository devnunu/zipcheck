package com.devnunu.zipcheck.ui.basicInfoDone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.components.view.NoteFailView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun BasicInfoDoneScreen(
    viewModel: BasicInfoDoneViewModel = koinViewModel(),
) {
    val navController = LocalNavController.current

    val scope: CoroutineScope = rememberCoroutineScope()

    ZipCheckScaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 12.dp)
            ) {
                BasicButton(
                    modifier = Modifier.weight(1f),
                    buttonStyle = BtnStyle.LIGHT_GREEN_RADIUS,
                    buttonSize = BtnSize.LARGE,
                    text = "이어서 작성하기",
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(10.dp))
                BasicButton(
                    modifier = Modifier.weight(1f),
                    buttonStyle = BtnStyle.PRIMARY_RADIUS,
                    buttonSize = BtnSize.LARGE,
                    text = "홈으로 가기",
                    onClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                bottom = paddingValues.calculateBottomPadding()
            )
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_check_round),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(26.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = BoldN20,
                    text = "집 보러 가기 전 체크리스트가\n저장되었어요!",
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            NoteFailView(
                onClickChangeToFailText = {
                    viewModel.onClickChangeHouseStatusFail(
                        onSuccess = {
                            scope.launch {
                                navController.popBackStack()
                            }
                        }
                    )
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}