package com.devnunu.zipcheck.ui.common

interface RatingDialogListener {
    fun onClickRate(index: Int, point: Int)
    fun onClickReset(index: Int)
}