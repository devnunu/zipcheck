package com.devnunu.zipcheck.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.applyIf
import com.devnunu.zipcheck.common.ext.clickableNonIndication
import com.devnunu.zipcheck.common.ext.clickableRipple
import com.devnunu.zipcheck.common.theme.*

enum class BtnStyle(
    val bgColor: Color,
    val txtColor: Color,
    val borderColor: Color?,
    val shape: Shape,
) {
    PRIMARY_RADIUS(lightMint8, white, null, RoundedCornerShape(14.dp)),
    PRIMARY_ROUND(lightMint8, white, null, RoundedCornerShape(100.dp)),

    DISABLE_RADIUS(gray99, gray80, null, RoundedCornerShape(14.dp)),
    DISABLE_ROUND(gray99, gray80, null, RoundedCornerShape(100.dp)),
}

enum class BtnSize(
    val paddingStart: Dp,
    val paddingTop: Dp,
    val paddingEnd: Dp,
    val paddingBottom: Dp
) {
    LARGE(20.dp, 12.dp, 20.dp, 12.dp),
    SMALL(12.dp, 6.dp, 12.dp, 6.dp),
}

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonStyle: BtnStyle = BtnStyle.PRIMARY_RADIUS,
    buttonSize: BtnSize = BtnSize.LARGE,
    enable: Boolean = true,
    onClick: () -> Unit,
) {

    val fontStyle = when (buttonSize) {
        BtnSize.LARGE -> Bold16
        BtnSize.SMALL -> Bold12
    }

    val btnModifier =
        if (enable) modifier.clickableRipple(onClick = onClick)
        else modifier

    Surface(
        modifier = btnModifier
            .clip(buttonStyle.shape)
            .applyIf(enable) {
                clickableRipple {
                    onClick()
                }
            },
        border = buttonStyle.borderColor?.let { BorderStroke(1.dp, it) },
        shape = buttonStyle.shape,
        color = buttonStyle.bgColor,
    ) {
        Text(
            modifier = Modifier.padding(
                top = buttonSize.paddingTop,
                bottom = buttonSize.paddingBottom,
                start = buttonSize.paddingStart,
                end = buttonSize.paddingEnd
            ),
            style = fontStyle,
            color = buttonStyle.txtColor,
            text = text,
            textAlign = TextAlign.Center,
        )
    }
}