package com.devnunu.zipcheck.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.ui.home.components.topBar.HomeTopBar
import com.devnunu.zipcheck.ui.home.components.view.HomeEmptyView
import com.devnunu.zipcheck.ui.home.components.view.HomeListView
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.collectAsState()

    val isHouseListEmpty = state.houseList.isEmpty()
    val navController = LocalNavController.current

    val onClickAddHouse = {
        navController.navigate(Routes.BasicInfoInput.route)
    }

    ZipCheckScaffold(
        bottomBar = {
            if (!isHouseListEmpty) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp, bottom = 30.dp)
                ) {
                    BasicButton(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        buttonStyle = BtnStyle.PRIMARY_ROUND,
                        buttonSize = BtnSize.LARGE,
                        iconRight = R.drawable.ic_add,
                        text = "집 추가하기",
                        onClick = { onClickAddHouse() }
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeTopBar()
            if (isHouseListEmpty) {
                HomeEmptyView(
                    onClickAddHouseBtn = { onClickAddHouse() }
                )
            } else {
                HomeListView(
                )
            }
        }
    }
}