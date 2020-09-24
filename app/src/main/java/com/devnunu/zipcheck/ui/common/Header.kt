package com.devnunu.zipcheck.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
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
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(
            "onClickBack",
            requireAll = false
        )
        fun setData(
            view: Header,
            onClickBack: OnClickListener?
        ) {
            onClickBack.let {
                view.binding.buttonLeft.setOnClickListener(onClickBack)
            }
        }
    }
}