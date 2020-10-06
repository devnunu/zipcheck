package com.devnunu.zipcheck.ui.common.input

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutCommonInputSelectBinding

class SelectInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: LayoutCommonInputSelectBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_common_input_select,
            this,
            true
        )


        binding.inputValue.setOnClickListener {
            dropDownClick()
        }

        changeStatus(InputStatus.BASIC)

        if (attrs != null) {
            val style = context.obtainStyledAttributes(attrs, R.styleable.SelectInput)
            if (style.hasValue(R.styleable.SelectInput_android_label)) {
                val label = style.getText(R.styleable.SelectInput_android_label)
                binding.textLabel.text = label
            }

            if (style.hasValue(R.styleable.SelectInput_android_hint)) {
                val hint = style.getText(R.styleable.SelectInput_android_hint)
                binding.inputValue.hint = hint
            }

            if (style.hasValue(R.styleable.BasicInput_android_enabled)) {
                val enabled = style.getBoolean(R.styleable.BasicInput_android_enabled, true)
                isEnabled = enabled
            }
        }
    }

    private fun changeStatus(status: InputStatus) {
        when (status) {
            InputStatus.BASIC -> {
                updateUIDesign(R.color.mono900, R.drawable.border_bottom_mono200_1dp)
            }
            InputStatus.FOCUS -> {
                updateUIDesign(R.color.blue500, R.drawable.border_bottom_emerald400_2dp)
            }
            InputStatus.DISABLE -> {
                updateUIDesign(R.color.mono900, 0)
            }
            InputStatus.ERROR -> {
                updateUIDesign(R.color.red700, R.drawable.border_bottom_red700_2dp)
            }
        }
    }

    override fun setEnabled(enabled: Boolean) {
        binding.inputValue.isEnabled = enabled
        if (!enabled) {
            changeStatus(InputStatus.DISABLE)
        }
    }

    private fun updateUIDesign(labelColor: Int, inputBackground: Int) {
        binding.textLabel.setTextColor(ContextCompat.getColor(context, labelColor))
        binding.inputValue.setBackgroundResource(inputBackground)
    }

    private fun dropDownClick() {
        performClick()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("value", requireAll = false)
        fun setData(
            view: SelectInput,
            value: CharSequence?
        ) {
            value?.let {
                view.binding.inputValue.setText(it)
                view.changeStatus(InputStatus.BASIC)
            }
        }
    }
}