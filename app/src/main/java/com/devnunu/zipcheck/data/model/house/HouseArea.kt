package com.devnunu.zipcheck.data.model.house

import com.devnunu.zipcheck.common.ext.roundDecimal

enum class HouseAreaType(val typeName: String) {
    PYONG("평"),
    METER("제곱미터")
}

data class HouseArea(
    val value: String? = null,
    val type: HouseAreaType? = null
) {
    val transformValue: Float
        get() = if (type == HouseAreaType.PYONG) {
            value?.toFloat()?.times(3.306f)?.roundDecimal(1) ?: 0f
        } else {
            value?.toFloat()?.div(3.306f)?.roundDecimal(1) ?: 0f
        }

    val transformType: HouseAreaType
        get() = if (type == HouseAreaType.PYONG) {
            HouseAreaType.METER
        } else {
            HouseAreaType.PYONG
        }
}