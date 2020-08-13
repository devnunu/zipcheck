package com.devnunu.zipcheck.common.util

import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.common.ZipCheckApplication.Companion.context

object StyleUtil {

    fun getDividerItemDecoration(@DrawableRes divider: Int): RecyclerView.ItemDecoration {
        val drawable = ContextCompat.getDrawable(context, divider)
        val dividerItemDecoration =
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        return drawable?.let {
            dividerItemDecoration.apply {
                setDrawable(it)
            }
        } ?: dividerItemDecoration
    }
}