package com.devnunu.zipcheck.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutCommonRateViewBinding

class RateView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val binding: LayoutCommonRateViewBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_common_rate_view,
            this,
            true
        )

        if (attrs != null) {
            val style = context.obtainStyledAttributes(attrs, R.styleable.RateView)
            if (style.hasValue(R.styleable.RateView_point)) {
                val point = style.getInt(R.styleable.RateView_point, 0)
                binding.point = point
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(
            "point",
            requireAll = false
        )
        fun setData(
            view: RateView,
            point: Int?
        ) {
            point?.let {
                view.binding.point = it
            }
        }
    }
}