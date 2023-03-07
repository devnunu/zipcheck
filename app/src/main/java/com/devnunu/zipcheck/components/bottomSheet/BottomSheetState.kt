package com.devnunu.zipcheck.components.bottomSheet

sealed class BottomSheetState<out T>(open val tag: T? = null) {
    data class Opened<out T>(override val tag: T? = null) : BottomSheetState<T>(tag = tag)
    data class Closed<out T>(override val tag: T? = null) : BottomSheetState<T>(tag = tag)

    fun close() = Closed(tag)
    fun <T> open(tag: T? = null) = Opened(tag)
}