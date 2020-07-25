package com.example.myapplication.common.ext

import android.view.View
import android.widget.TextView

fun TextView.visibleIf(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}