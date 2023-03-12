package com.devnunu.zipcheck.ui.tempOption

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.theme.Bold20
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.tempOption.components.TempOptionItem
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun TempOptionScreen(
    viewModel: TempOptionViewModel
) {

    val state by viewModel.collectAsState()

    val houseOptionList = state.houseOptionList

    val navController = LocalNavController.current

    ZipCheckScaffold(
        topBar = {
            TopBar(
                title = "옵션",
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
                onClick = {}
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                style = Bold20,
                text = "어떤 옵션들이 있나요?"
            )
            Spacer(modifier = Modifier.height(34.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(houseOptionList) { houseOption ->
                    TempOptionItem(
                        houseOption = houseOption,
                        onClickItem = {
                            viewModel.onClickItem(houseOption)
                        },
                    )
                }
            }
        }
    }
}