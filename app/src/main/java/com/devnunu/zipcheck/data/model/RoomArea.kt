package com.devnunu.zipcheck.data.model

import com.devnunu.zipcheck.common.ext.roundDecimal

enum class RoomAreaType(val typeName: String) {
    PYONG("평"),
    METER("제곱미터")
}

data class RoomArea(
    val value: String? = null,
    val type: RoomAreaType
) {
    val transformValue: Float
        get() = if (type == RoomAreaType.PYONG) {
            value?.toFloat()?.times(3.306f)?.roundDecimal(1)?: 0f
        } else {
            value?.toFloat()?.div(3.306f)?.roundDecimal(1)?: 0f
        }

    val transformType: RoomAreaType
        get() = if (type == RoomAreaType.PYONG) {
            RoomAreaType.METER
        } else {
            RoomAreaType.PYONG
        }
}