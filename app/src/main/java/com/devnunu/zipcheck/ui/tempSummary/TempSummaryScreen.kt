package com.devnunu.zipcheck.ui.tempSummary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.common.theme.Bold18
import com.devnunu.zipcheck.common.theme.Bold20
import com.devnunu.zipcheck.common.theme.Regular14
import com.devnunu.zipcheck.common.theme.lightSlate11
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.data.model.house.HouseBenefit
import com.devnunu.zipcheck.ui.tempSummary.components.HouseSummarySelector
import com.devnunu.zipcheck.ui.tempSummary.components.HouseSummaryTag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun TempSummaryScreen(
    viewModel: TempSummaryViewModel
) {

    val state by viewModel.collectAsState()

    val house = state.house
    val selectedSummary = state.selectedSummary
    val houseBenefitList = state.houseBenefitList

    val navController = LocalNavController.current
    val scope: CoroutineScope = rememberCoroutineScope()

    ZipCheckScaffold(
        topBar = {
            TopBar(
                title = "총평",
                onClickBackBtn = { navController.popBackStack() }
            )
        },
        bottomBar = {
            BasicButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 12.dp),
                buttonStyle = BtnStyle.PRIMARY_RADIUS,
                buttonSize = BtnSize.LARGE,
                text = "저장하기",
                onClick = {
                    viewModel.onClickSave(
                        onSuccess = {
                            scope.launch {
                                navController.navigate(
                                    Routes.TempDone.getArgumentsRoute(
                                        house?.id
                                    )
                                )
                            }
                        }
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = paddingValues.calculateBottomPadding()
                )
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                style = Bold20,
                text = "이 집은 어떠셨나요?"
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                style = Regular14,
                text = "별로에요를 선택하면 바로 탈락 리스트로 보내져요.",
                color = lightSlate11
            )
            Spacer(modifier = Modifier.height(21.dp))
            HouseSummarySelector(
                selectedSummary = selectedSummary,
                onClickSummary = viewModel::onClickSummary
            )
            Spacer(modifier = Modifier.height(55.dp))
            Text(
                style = Bold18,
                text = "이 집의 좋았던점을 모두 선택해주세요."
            )
            Spacer(modifier = Modifier.height(30.dp))
            HouseBenefit.values().forEach { houseBenefit ->
                HouseSummaryTag(
                    houseBenefit = houseBenefit,
                    isSelected = houseBenefitList.contains(houseBenefit),
                    onClickHouseBenefit = viewModel::onClickHouseBenefit
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}