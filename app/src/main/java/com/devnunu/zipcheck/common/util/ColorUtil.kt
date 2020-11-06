package com.devnunu.zipcheck.common.util

import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.devnunu.zipcheck.common.ZipCheckApplication.Companion.context

object ColorUtil {
    fun getColorToIdRes(@ColorRes idRes: Int) = ContextCompat.getColor(context, idRes)

    fun View.getColorToId(@ColorRes idRes: Int) = ContextCompat.getColor(context, idRes)
}