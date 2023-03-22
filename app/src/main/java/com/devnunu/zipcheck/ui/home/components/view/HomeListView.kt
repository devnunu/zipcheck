package com.devnunu.zipcheck.ui.home.components.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.common.theme.Medium20
import com.devnunu.zipcheck.common.theme.lightSlate6
import com.devnunu.zipcheck.common.theme.lightSlate8
import com.devnunu.zipcheck.data.model.house.HouseWriteStatus
import com.devnunu.zipcheck.ui.home.HomeViewModel
import com.devnunu.zipcheck.ui.home.components.indicator.HomeStatusIndicator
import com.devnunu.zipcheck.ui.home.components.item.HouseItem
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun HomeListView(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.collectAsState()

    val houseList = state.filteredHouseList
    val currentSortStatus = state.currentSortStatus

    val navController = LocalNavController.current

    Column(
        modifier = modifier,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeStatusIndicator(
                currentSortStatus = state.currentSortStatus,
                onClickIndicator = viewModel::onClickIndicator
            )
        }
        if (houseList.isEmpty()) {
            val text = if (currentSortStatus == HouseWriteStatus.IN_PROGRESS) {
                "아직 작성중인 집이 없어요."
            } else {
                "아직 탈락한 집이 없어요."
            }
            HomeEmptyListView(text = text)
        } else {
            LazyColumn(
                contentPadding = PaddingValues(top = 30.dp, bottom = 80.dp)
            ) {
                itemsIndexed(houseList) { index, house ->
                    HouseItem(
                        house = house,
                        onClick = {
                            navController.navigate(
                                Routes.TempBasicInfo.getArgumentsRoute(
                                    house.id
                                )
                            )
                        }
                    )
                    if (index < houseList.lastIndex) {
                        Divider(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            color = lightSlate6.copy(alpha = 0.4f),
                            thickness = 1.dp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeEmptyListView(
    modifier: Modifier = Modifier,
    text: String
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(9f))
        Icon(
            modifier = modifier.size(32.dp),
            painter = painterResource(id = R.drawable.ic_warning),
            contentDescription = null,
            tint = lightSlate8
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            style = Medium20,
            text = text
        )
        Spacer(modifier = Modifier.weight(17f))
    }

}