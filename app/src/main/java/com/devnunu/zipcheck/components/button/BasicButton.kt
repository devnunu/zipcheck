package com.devnunu.zipcheck.components.button

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devnunu.zipcheck.common.ext.applyIf
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

    LINE_RADIUS(white, lightSlate11, lightSlate7, RoundedCornerShape(14.dp)),
    LINE_ROUND(white, lightSlate11, lightSlate7, RoundedCornerShape(100.dp)),

    DISABLE_RADIUS(lightSlate6, lightSlate9, null, RoundedCornerShape(14.dp)),
    DISABLE_ROUND(lightSlate6, lightSlate9, null, RoundedCornerShape(100.dp)),
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
    @DrawableRes iconRight: Int? = null,
    @DrawableRes iconLeft: Int? = null,
    buttonStyle: BtnStyle = BtnStyle.PRIMARY_RADIUS,
    buttonSize: BtnSize = BtnSize.LARGE,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    val buttonStyle = if (enable) buttonStyle else {
        when (buttonStyle) {
            BtnStyle.PRIMARY_RADIUS,
            BtnStyle.LINE_ROUND -> BtnStyle.DISABLE_RADIUS
            else -> BtnStyle.DISABLE_ROUND
        }
    }

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
        Row(
            modifier = Modifier.padding(
                top = buttonSize.paddingTop,
                bottom = buttonSize.paddingBottom,
                start = buttonSize.paddingStart,
                end = buttonSize.paddingEnd
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (iconRight != null) {
                Icon(
                    painter = painterResource(id = iconRight),
                    contentDescription = null,
                    tint = buttonStyle.txtColor
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                style = fontStyle,
                color = buttonStyle.txtColor,
                text = text,
                textAlign = TextAlign.Center,
            )
            if (iconLeft != null) {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = iconLeft),
                    contentDescription = null,
                    tint = buttonStyle.txtColor
                )
            }
        }
    }
}