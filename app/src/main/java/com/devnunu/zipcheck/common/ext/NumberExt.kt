package com.devnunu.zipcheck.common.ext

import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.roundToInt

fun Float?.roundDecimal(decimal: Int): Float {
    val decimalPoint: Float = (10.0f).pow(decimal)
    return this?.times(decimalPoint)?.roundToInt()?.div(decimalPoint) ?: 0f
}

fun Long?.toKrCurrencyFullText(addUnit: Boolean = false): String {
    if (this == null) return if (addUnit) "0원" else "0"
    var remainValue = this
    var result = ""
    if (remainValue >= 100000000) {
        result += "${toCurrencyFormText(remainValue / 100000000)}억 "
        remainValue -= remainValue / 100000000 * 100000000
    }
    if (remainValue >= 10000) {
        result += "${toCurrencyFormText(remainValue / 10000)}만 "
        remainValue -= 10000
        remainValue -= remainValue / 10000 * 10000
    }
    if (remainValue != 0L) {
        result += toCurrencyFormText(remainValue)
    }
    return if (addUnit) "${result.trim()}원" else result.trim()
}

fun toCurrencyFormText(value: Any?): String {
    if (value == null) return "0"
    val decimalFormat = DecimalFormat("#,###")
    return try {
        decimalFormat.format(value)
    } catch (e: IllegalArgumentException) {
        "0"
    }
}