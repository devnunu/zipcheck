package com.devnunu.zipcheck.common.util

import java.text.DecimalFormat

object CurrencyUtil {
    @JvmStatic
    fun toKrCurrencyText(value: Long?, addUnit: Boolean = false): String {
        if (value == null) return if (addUnit) "0 원" else "0"
        var remainValue = value
        var result = ""
        if (remainValue > 100000000) {
            result += "${toCurrencyFormText(remainValue / 100000000)}억 "
            remainValue -= remainValue / 100000000 * 100000000
        }
        if (remainValue > 10000) {
            result += "${toCurrencyFormText(remainValue / 10000)}만 "
            remainValue -= 10000
        }
        return if (addUnit) "${result.trim()}원" else result.trim()
    }

    private fun toCurrencyFormText(value: Any?): String {
        if (value == null) return "0"
        val decimalFormat = DecimalFormat("#,###")
        return try {
            decimalFormat.format(value)
        } catch (e: IllegalArgumentException) {
            "0"
        }
    }
}