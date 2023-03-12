package com.devnunu.zipcheck.ui.tempOption.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.ext.clickableRipple
import com.devnunu.zipcheck.common.theme.*
import com.devnunu.zipcheck.components.checkBox.ZipCheckCheckBox
import com.devnunu.zipcheck.data.model.HouseOption

@Composable
fun TempOptionItem(
    houseOption: HouseOption,
    onClickItem: (HouseOption) -> Unit,
) {
    val isSelected = houseOption.selected
    val borderColor = if (isSelected) lightMint8 else lightSlate6
    Box(
        modifier = Modifier
            .height(120.dp)
            .clickableNonIndication { onClickItem(houseOption) }
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
    ) {
        ZipCheckCheckBox(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 4.dp, end = 4.dp),
            checked = isSelected,
            onCheckedChange = { onClickItem(houseOption) }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            val iconTint = if (isSelected) lightSlate11 else lightSlate8
            Icon(
                painter = painterResource(id = houseOption.iconRedId),
                contentDescription = null,
                tint = iconTint
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier.height(36.dp),
                contentAlignment = Alignment.Center,
            ) {
                val textColor = if (isSelected) lightSlate12 else lightSlate10
                Text(
                    style = Medium12,
                    text = houseOption.optionName,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}