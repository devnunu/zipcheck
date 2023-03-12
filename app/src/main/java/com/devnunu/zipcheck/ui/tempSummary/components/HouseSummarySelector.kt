package com.devnunu.zipcheck.ui.tempSummary.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.theme.lightSlate7
import com.devnunu.zipcheck.components.selector.SelectorDivider
import com.devnunu.zipcheck.components.selector.SelectorItem
import com.devnunu.zipcheck.data.model.Summary

@Composable
fun HouseSummarySelector(
    selectedSummary: Summary?,
    onClickSummary: (Summary) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .border(1.dp, lightSlate7, RoundedCornerShape(6.dp))
            .clip(RoundedCornerShape(6.dp))
    ) {
        SelectorItem(
            modifier = Modifier.weight(1f),
            isSelected = selectedSummary == Summary.GOOD,
            text = Summary.GOOD.summary,
            onClick = { onClickSummary(Summary.GOOD) }
        )
        SelectorDivider(
            isInvisible = selectedSummary == Summary.GOOD || selectedSummary == Summary.NORMAL
        )
        SelectorItem(
            modifier = Modifier.weight(1f),
            isSelected = selectedSummary == Summary.NORMAL,
            text = Summary.NORMAL.summary,
            onClick = { onClickSummary(Summary.NORMAL) }
        )
        SelectorDivider(
            isInvisible = selectedSummary == Summary.NORMAL || selectedSummary == Summary.BAD
        )
        SelectorItem(
            modifier = Modifier.weight(1f),
            isSelected = selectedSummary == Summary.BAD,
            text = Summary.BAD.summary,
            onClick = { onClickSummary(Summary.BAD) }
        )
    }
}