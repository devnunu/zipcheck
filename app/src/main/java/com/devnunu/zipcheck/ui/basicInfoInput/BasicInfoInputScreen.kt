package com.devnunu.zipcheck.ui.basicInfoInput

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel.Companion.PAGE_FIRST
import com.devnunu.zipcheck.ui.basicInfoInput.BasicInfoInputViewModel.Companion.PAGE_SECOND
import com.devnunu.zipcheck.ui.basicInfoInput.components.BasicInfoInputStepIndicator
import com.devnunu.zipcheck.ui.basicInfoInput.components.view.BasicInfoFirstStepView
import com.devnunu.zipcheck.ui.basicInfoInput.components.view.BasicInfoSecondStepView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasicInfoInputScreen(
    viewModel: BasicInfoInputViewModel = koinViewModel()
) {
    val state by viewModel.collectAsState()

    val navController = LocalNavController.current

    val scope: CoroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    LaunchedEffect(pagerState.currentPage) {
        viewModel.onPageChange(pagerState.currentPage)
    }
    BackHandler {
        if (pagerState.currentPage == PAGE_SECOND) {
            scope.launch {
                pagerState.animateScrollToPage(PAGE_FIRST)
            }
        } else {
            navController.popBackStack()
        }
    }
    ZipCheckScaffold(
        topBar = {
            TopBar(
                title = "집보러 가기 전 체크 리스트",
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
                text = "다음",
                enable = state.isBtnAndScrollEnable,
                onClick = {
                    if (pagerState.currentPage == PAGE_FIRST) {
                        scope.launch {
                            pagerState.animateScrollToPage(PAGE_SECOND)
                        }
                    } else {
                        navController.popBackStack()
                        navController.navigate(Routes.BasicInfoDone.route)
                    }

                }
            )
        }
    ) { paddingValues ->
        BasicInfoInputStepIndicator(
            modifier = Modifier.fillMaxWidth(),
            currentPage = pagerState.currentPage
        )
        HorizontalPager(
            pageCount = 2,
            userScrollEnabled = state.isBtnAndScrollEnable,
            state = pagerState
        ) { page ->
            when (page) {
                PAGE_FIRST -> {
                    BasicInfoFirstStepView(
                        modifier = Modifier.padding(
                            bottom = paddingValues.calculateBottomPadding()
                        )
                    )
                }
                else -> {
                    BasicInfoSecondStepView(
                        modifier = Modifier.padding(
                            bottom = paddingValues.calculateBottomPadding()
                        )
                    )
                }
            }
        }
    }
}