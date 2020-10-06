package com.devnunu.zipcheck.ui.common.text

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutCommonKeyValueBinding

class KeyValueText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val binding: LayoutCommonKeyValueBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_common_key_value,
            this,
            true
        )

        if (attrs != null) {
            val style = context.obtainStyledAttributes(attrs, R.styleable.KeyValueText)
            if (style.hasValue(R.styleable.KeyValueText_key)) {
                val key = style.getText(R.styleable.KeyValueText_key)
                binding.textKey.text = key
            }

            if (style.hasValue(R.styleable.KeyValueText_value)) {
                val value = style.getText(R.styleable.KeyValueText_value)
                binding.textValue.text = value
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(
            "value",
            requireAll = false
        )
        fun setData(
            view: KeyValueText,
            value: CharSequence?
        ) {
            value?.let {
                view.binding.textValue.text = it
            }
        }
    }
}