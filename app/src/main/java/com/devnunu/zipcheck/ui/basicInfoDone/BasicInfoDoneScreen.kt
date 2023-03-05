package com.devnunu.zipcheck.ui.basicInfoDone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavOptions
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.ext.navigateWithPopUp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.common.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun BasicInfoDoneScreen(
    viewModel: BasicInfoDoneViewModel = koinViewModel(),
    houseId: String? = null
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
                            houseId?.let {
                                viewModel.onClickChangeHouseStatusFail(
                                    houseId = it,
                                    onSuccess= {
                                        scope.launch {
                                            navController.popBackStack()
                                        }
                                    }
                                )
                            }
                        },
                        style = Regular12,
                        text = "탈락 리스트로 옮기기",
                        color = lightSlate9,
                        textDecoration = TextDecoration.Underline,
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}