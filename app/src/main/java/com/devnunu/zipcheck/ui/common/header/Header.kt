package com.devnunu.zipcheck.ui.common.header

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutCommonHeaderBinding

class Header @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val binding: LayoutCommonHeaderBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_common_header,
            this,
            true
        )

        if (attrs != null) {
            val style = context.obtainStyledAttributes(attrs, R.styleable.Header)
            if (style.hasValue(R.styleable.Header_title)) {
                val title = style.getText(R.styleable.Header_title)
                binding.textTitle.text = title
            }
            if (style.hasValue(R.styleable.Header_rightImage)) {
                val src = style.getDrawable(R.styleable.Header_rightImage)
                binding.imgRightIcon.setImageDrawable(src)
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(
            "title",
            "onClickBack",
            "onClickRightIcon",
            requireAll = false
        )
        fun setData(
            view: Header,
            title:CharSequence?,
            onClickBack: OnClickListener?,
            onClickRightIcon: OnClickListener?
        ) {
            title?.let {
                view.binding.textTitle.text = it
            }
            onClickBack?.let {
                view.binding.buttonLeft.setOnClickListener(it)
            }
            onClickRightIcon?.let {
                view.binding.imgRightIcon.setOnClickListener(it)
            }
        }
    }
}