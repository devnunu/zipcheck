package com.devnunu.zipcheck.common.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.devnunu.zipcheck.R

val Typography: Typography
    get() = Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )

val fonts = FontFamily(
    Font(R.font.pretendard_bold, weight = FontWeight.Bold),
    Font(R.font.pretendard_medium, weight = FontWeight.Medium),
    Font(R.font.pretendard_regular, weight = FontWeight.Normal),
    Font(R.font.pretendard_light, weight = FontWeight.Light),
)

val Bold = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Bold,
    color = lightSlate12
)

val Medium = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Medium,
    color = lightSlate12
)

val Regular = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    color = lightSlate12
)

val Bold30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (30 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (33 / fontScale).sp },
        color = lightSlate12
    )

val BoldN30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (30 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (40.5 / fontScale).sp },
        color = lightSlate12
    )

val MediumN30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (30 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (40.5 / fontScale).sp },
        color = lightSlate12
    )

val Medium30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (30 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (33 / fontScale).sp },
        color = lightSlate12
    )

val RegularN30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (30 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (40.5 / fontScale).sp },
        color = lightSlate12
    )

val Regular30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (30 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (33 / fontScale).sp },
        color = lightSlate12
    )

val LightN30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (30 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (45 / fontScale).sp },
        color = lightSlate12
    )

val Light30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (30 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (33 / fontScale).sp },
        color = lightSlate12
    )

val Bold27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (27 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.54 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (29.7 / fontScale).sp },
        color = lightSlate12
    )

val BoldN27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (27 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.54 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (39.2 / fontScale).sp },
        color = lightSlate12
    )

val MediumN27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (27 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.54 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (40.5 / fontScale).sp },
        color = lightSlate12
    )

val Medium27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (27 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.54 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (29.7 / fontScale).sp },
        color = lightSlate12
    )

val Regular27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (27 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.54 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (29.7 / fontScale).sp },
        color = lightSlate12
    )

val RegularN27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (27 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.54 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (36.5 / fontScale).sp },
        color = lightSlate12
    )

val Light27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (27 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.54 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (29.7 / fontScale).sp },
        color = lightSlate12
    )

val LightN27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (27 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-1.35 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (39.2 / fontScale).sp },
        color = lightSlate12
    )

val BoldN26: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (26 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-1.04 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (35.1 / fontScale).sp },
        color = lightSlate12
    )

val LightN26: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (26 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-1.04 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (35.1 / fontScale).sp },
        color = lightSlate12
    )

val BoldN25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (25 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.5 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (33.8 / fontScale).sp },
        color = lightSlate12
    )

val Bold25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (25 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.62 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (27.5 / fontScale).sp },
        color = lightSlate12
    )

val MediumN25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (25 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.5 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (37.5 / fontScale).sp },
        color = lightSlate12
    )

val Medium25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (25 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.5 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (27.5 / fontScale).sp },
        color = lightSlate12
    )

val RegularN25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (25 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.5 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (33.8 / fontScale).sp },
        color = lightSlate12
    )

val Regular25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (25 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.5 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (27.5 / fontScale).sp },
        color = lightSlate12
    )

val LightN25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (25 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.5 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (37.5 / fontScale).sp },
        color = lightSlate12
    )

val Light25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (25 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.5 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (27.5 / fontScale).sp },
        color = lightSlate12
    )

val BoldN24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (24 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (32.4 / fontScale).sp },
        color = lightSlate12
    )

val Bold24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (24 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.6 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (26.4 / fontScale).sp },
        color = lightSlate12
    )

val MediumN24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (24 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.48 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (36 / fontScale).sp },
        color = lightSlate12
    )

val Medium24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (24 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.48 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (26.4 / fontScale).sp },
        color = lightSlate12
    )

val RegularN24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (24 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.48 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (32.4 / fontScale).sp },
        color = lightSlate12
    )

val Regular24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (24 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.48 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (26.4 / fontScale).sp },
        color = lightSlate12
    )

val LightN24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (24 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.48 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (36 / fontScale).sp },
        color = lightSlate12
    )

val Light24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (24 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.48 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (26.4 / fontScale).sp },
        color = lightSlate12
    )

val Bold22: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (22 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.44 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (24.2 / fontScale).sp },
        color = lightSlate12
    )

val BoldN22: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (22 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.44 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (30.8 / fontScale).sp },
        color = lightSlate12
    )

val Regular22: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (22 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.44 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (24.2 / fontScale).sp },
        color = lightSlate12
    )

val RegularN22: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (22 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.44 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (30.8 / fontScale).sp },
        color = lightSlate12
    )

val BoldN20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (20 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.4 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (27 / fontScale).sp },
        color = lightSlate12
    )

val Bold20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (20 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.4 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (22 / fontScale).sp },
        color = lightSlate12
    )

val MediumN20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (20 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.4 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (30 / fontScale).sp },
        color = lightSlate12
    )

val Medium20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (20 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.4 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (22 / fontScale).sp },
        color = lightSlate12
    )

val RegularN20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (20 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.4 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (27 / fontScale).sp },
        color = lightSlate12
    )

val Regular20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (20 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.4 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (22 / fontScale).sp },
        color = lightSlate12
    )

val LightN20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (20 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.4 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (30 / fontScale).sp },
        color = lightSlate12
    )

val Light20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (20 / fontScale).sp },
        fontWeight = FontWeight.Light,
        letterSpacing = with(LocalDensity.current) { (-0.4 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (22 / fontScale).sp },
        color = lightSlate12
    )

val BoldN18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (18 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.36 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (27 / fontScale).sp },
        color = lightSlate12
    )

val Bold18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (18 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.36 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (19.8 / fontScale).sp },
        color = lightSlate12
    )

val MediumN18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (18 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.36 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (24.3 / fontScale).sp },
        color = lightSlate12
    )

val Medium18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (18 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.36 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (19.8 / fontScale).sp },
        color = lightSlate12
    )

val RegularN18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (18 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.36 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (27 / fontScale).sp },
        color = lightSlate12
    )

val Regular18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (18 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.36 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (19.8 / fontScale).sp },
        color = lightSlate12
    )

val BoldN16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (16 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.32 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (21.6 / fontScale).sp },
        color = lightSlate12
    )

val Bold16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (16 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.32 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (17.6 / fontScale).sp },
        color = lightSlate12
    )

val MediumN16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (16 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.32 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (24 / fontScale).sp },
        color = lightSlate12
    )

val Medium16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (16 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.32 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (17.6 / fontScale).sp },
        color = lightSlate12
    )

val RegularN16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (16 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.32 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (21.6 / fontScale).sp },
        color = lightSlate12
    )

val Regular16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (16 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.32 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (17.6 / fontScale).sp },
        color = lightSlate12
    )

val BoldN14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (14 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.14 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (21 / fontScale).sp },
        color = lightSlate12
    )

val Bold14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (14 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.14 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (15.4 / fontScale).sp },
        color = lightSlate12
    )

val MediumN14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (14 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.14 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (18.9 / fontScale).sp },
        color = lightSlate12
    )

val Medium14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (14 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.14 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (15.4 / fontScale).sp },
        color = lightSlate12
    )

val RegularN14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (14 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.14 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (21 / fontScale).sp },
        color = lightSlate12
    )

val Regular14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (14 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.14 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (15.4 / fontScale).sp },
        color = lightSlate12
    )

val BoldN12: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (12 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.12 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (18 / fontScale).sp },
        color = lightSlate12
    )

val Bold12: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (12 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.12 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (13.2 / fontScale).sp },
        color = lightSlate12
    )

val MediumN12: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (12 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.12 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (16.2 / fontScale).sp },
        color = lightSlate12
    )

val Medium12: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (12 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.12 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (13.2 / fontScale).sp },
        color = lightSlate12
    )

val Regular12: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (12 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        letterSpacing = with(LocalDensity.current) { (-0.12 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (13.2 / fontScale).sp },
        color = lightSlate12
    )

val Bold11: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (12 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        letterSpacing = with(LocalDensity.current) { (-0.06 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (12.6 / fontScale).sp },
        color = lightSlate12
    )

val Medium11: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (11 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.11 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (12.1 / fontScale).sp },
        color = lightSlate12
    )

val Bold10: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (10 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        lineHeight = with(LocalDensity.current) { (11 / fontScale).sp },
        color = lightSlate12
    )

val MediumN10: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (10 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.1 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (13.5 / fontScale).sp },
        color = lightSlate12
    )

val Medium10: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (10 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.1 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (11 / fontScale).sp },
        color = lightSlate12
    )

/**
 * 디자인 시스템에 적용하지 못한 예외폰트들
 */
val Medium08: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (8 / fontScale).sp },
        fontWeight = FontWeight.Medium,
        letterSpacing = with(LocalDensity.current) { (-0.1 / fontScale).sp },
        lineHeight = with(LocalDensity.current) { (11 / fontScale).sp },
        color = lightSlate12
    )

val Bold08: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (8 / fontScale).sp },
        fontWeight = FontWeight.Bold,
        lineHeight = with(LocalDensity.current) { (11 / fontScale).sp },
        color = lightSlate12
    )

val Regular13: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = with(LocalDensity.current) { (13 / fontScale).sp },
        fontWeight = FontWeight.Normal,
        lineHeight = with(LocalDensity.current) { (11 / fontScale).sp },
        color = lightSlate12
    )

