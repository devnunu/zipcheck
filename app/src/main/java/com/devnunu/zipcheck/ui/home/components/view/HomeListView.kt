package com.devnunu.zipcheck.ui.home.components.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.lightSlate6
import com.devnunu.zipcheck.ui.home.HomeViewModel
import com.devnunu.zipcheck.ui.home.components.item.HouseItem
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun HomeListView(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.collectAsState()

    val houseList = state.houseList

    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(houseList) { index, house ->
            HouseItem(
                house = house,
                onClick = {}
            )
            if (index < houseList.lastIndex) {
                Divider(
                    color = lightSlate6,
                    thickness = 1.dp
                )
            }
        }
    }
}