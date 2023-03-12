package com.devnunu.zipcheck.ui.tempCheck

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.navigation.LocalNavController
import com.devnunu.zipcheck.common.navigation.Routes
import com.devnunu.zipcheck.common.theme.BoldN20
import com.devnunu.zipcheck.common.theme.lightSlate3
import com.devnunu.zipcheck.components.button.BasicButton
import com.devnunu.zipcheck.components.button.BtnSize
import com.devnunu.zipcheck.components.button.BtnStyle
import com.devnunu.zipcheck.components.checkBox.CheckBoxText
import com.devnunu.zipcheck.components.scaffold.ZipCheckScaffold
import com.devnunu.zipcheck.components.topBar.TopBar
import com.devnunu.zipcheck.ui.tempCheck.components.TempCheckRoomTypeSelector
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun TempCheckScreen(
    viewModel: TempCheckViewModel
) {
    val state by viewModel.collectAsState()
    val house = state.house

    val filteredRoomTypeChecklist = state.filteredRoomTypeChecklist
    val selectedCheckList = state.selectedChecklist

    val navController = LocalNavController.current

    ZipCheckScaffold(
        topBar = {
            TopBar(
                title = selectedCheckList?.name,
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
                text = "확인완료",
                onClick = {
                    navController.navigate(
                        Routes.TempOptionInfo.getArgumentsRoute(
                            house?.id
                        )
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TempCheckRoomTypeSelector(
                    roomTypeList = filteredRoomTypeChecklist,
                    selectedCheckList = selectedCheckList,
                    onClickRoomType = viewModel::onClickRoomType
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 8.dp,
                color = lightSlate3
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)
            ) {
                val description = state.description
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    style = BoldN20,
                    text = description
                )
                Spacer(modifier = Modifier.height(40.dp))
                selectedCheckList?.checklist?.forEachIndexed { index, checklistItem ->
                    if (index != 0) {
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                    CheckBoxText(
                        checked = checklistItem.isChecked,
                        text = checklistItem.name,
                        onCheckedChange = { isChecked ->
                            viewModel.onCheckChange(index, isChecked)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(80.dp))

            }
        }
    }
}