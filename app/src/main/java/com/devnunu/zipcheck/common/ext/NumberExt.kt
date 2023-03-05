package com.devnunu.zipcheck.common.ext

import kotlin.math.pow
import kotlin.math.roundToInt

fun Float?.roundDecimal(decimal: Int): Float {
    val decimalPoint: Float = (10.0f).pow(decimal)
    return this?.times(decimalPoint)?.roundToInt()?.div(decimalPoint) ?: 0f
}

