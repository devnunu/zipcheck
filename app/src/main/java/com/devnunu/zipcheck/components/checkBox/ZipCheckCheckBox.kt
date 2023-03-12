package com.devnunu.zipcheck.components.checkBox

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.theme.lightMint8
import com.devnunu.zipcheck.common.theme.lightSlate5
import com.devnunu.zipcheck.common.theme.lightSlate7
import com.devnunu.zipcheck.common.theme.white

@Composable
fun ZipCheckCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    @DrawableRes customCheckedIconId: Int? = null,
    onCheckedChange: (Boolean) -> Unit,
) {
    val borderColor: Color by animateColorAsState(
        targetValue = if (checked) lightMint8 else lightSlate7,
        animationSpec = tween(
            durationMillis = 300,
        )
    )
    val bgColor: Color by animateColorAsState(
        targetValue = if (checked) lightMint8 else white,
        animationSpec = tween(
            durationMillis = 300,
        )
    )

    Box(
        modifier = modifier
            .size(24.dp)
            .clickableNonIndication { onCheckedChange(!checked) }
            .border(1.dp, borderColor, RoundedCornerShape(6.dp))
            .background(bgColor, RoundedCornerShape(6.dp)),
    ) {
        Icon(
            modifier = modifier
                .size(16.dp)
                .align(Alignment.Center),
            painter = painterResource(id = customCheckedIconId ?: R.drawable.ic_check),
            contentDescription = null,
            tint = white
        )
    }
}

@Preview(
    showBackground = true,
    name = "checked"
)
@Composable
fun ZipCheckCheckBoxPreview1() {
    ZipCheckCheckBox(
        checked = true,
        onCheckedChange = {}
    )
}

@Preview(
    showBackground = true,
    name = "unchecked"
)
@Composable
fun ZipCheckCheckBoxPreview2() {
    ZipCheckCheckBox(
        checked = true,
        onCheckedChange = {}
    )
}