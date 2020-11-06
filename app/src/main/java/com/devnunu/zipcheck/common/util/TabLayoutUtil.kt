package com.devnunu.zipcheck.common.util

import android.graphics.Typeface
import androidx.appcompat.widget.AppCompatTextView
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.util.ColorUtil.getColorToId
import com.google.android.material.tabs.TabLayout

object TabLayoutUtil {

    val onFindaTabSelectedListener: () -> TabLayout.OnTabSelectedListener = {
        object : TabLayout.OnTabSelectedListener {
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView.apply {
                    if (this is AppCompatTextView) {
                        setTextColor(getColorToId(R.color.mono600))
                        typeface = Typeface.DEFAULT
                    }
                }
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView.apply {
                    if (this is AppCompatTextView) {
                        setTextColor(getColorToId(R.color.emerald600))
                        typeface = Typeface.DEFAULT_BOLD
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        }
    }
}