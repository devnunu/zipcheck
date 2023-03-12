package com.devnunu.zipcheck.ui.tempDone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.common.theme.BoldN20
import com.devnunu.zipcheck.common.theme.MediumN14
import com.devnunu.zipcheck.common.theme.lightSlate11
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.view.NoteFailView
import com.devnunu.zipcheck.data.model.HouseWriteStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun TempDoneScreen(
    viewModel: TempDoneViewModel
) {

    val state by viewModel.collectAsState()
    val house = state.house

    val scope: CoroutineScope = rememberCoroutineScope()

    val navController = LocalNavController.current

    ZipCheckScaffold(
        bottomBar = {
            BasicButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 12.dp),
                buttonStyle = BtnStyle.PRIMARY_RADIUS,
                buttonSize = BtnSize.LARGE,
                text = "다음",
                onClick = {
                    navController.popBackStack(
                        route = Routes.Home.route,
                        inclusive = false
                    )
                }
            )
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
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = BoldN20,
                    text = "${house?.alias.orEmpty()}집의 정보가\n저장되었어요!",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MediumN14,
                    text = "저장한 내용은 홈 화면에서 \n언제든 다시 볼 수 있어요.",
                    textAlign = TextAlign.Center,
                    color = lightSlate11
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            if (house?.houseWriteStatus == HouseWriteStatus.FAIL)
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