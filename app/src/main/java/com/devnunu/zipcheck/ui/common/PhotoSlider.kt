package com.devnunu.zipcheck.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutCommonPhotoSliderBinding

class PhotoSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val binding: LayoutCommonPhotoSliderBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_common_photo_slider,
            this,
            true
        )

        if (attrs != null) {
            val style = context.obtainStyledAttributes(attrs, R.styleable.PhotoSlider)
//            if (style.hasValue(R.styleable.Header_title)) {
//                val title = style.getText(R.styleable.Header_title)
//                binding.textTitle.text = title
//            }
        }
    }
}