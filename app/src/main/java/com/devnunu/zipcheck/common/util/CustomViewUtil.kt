package com.devnunu.zipcheck.common.util

import android.graphics.Typeface
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ZipCheckApplication.Companion.context
import com.devnunu.zipcheck.common.util.ColorUtil.getColorToId

object CustomViewUtil {

    fun createCustomFontTextViewForTab(position: Int, textArray: Array<String>): AppCompatTextView {
        val customFontTextView = AppCompatTextView(context)

        customFontTextView.apply {
            gravity = Gravity.CENTER
            textSize = 16f

            text = textArray[position]

            if (position == 0) {
                typeface = Typeface.DEFAULT_BOLD
                setTextColor(getColorToId(R.color.emerald600))
            } else {
                typeface = Typeface.DEFAULT
                setTextColor(getColorToId(R.color.mono600))
            }
        }

        return customFontTextView
    }
}