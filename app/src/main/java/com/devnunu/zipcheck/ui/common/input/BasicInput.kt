package com.devnunu.zipcheck.ui.common.input

import android.content.Context
import android.graphics.Rect
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.ext.showKeyboard
import com.devnunu.zipcheck.databinding.LayoutCommonInputBasicBinding

class BasicInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: LayoutCommonInputBasicBinding

    private var currentStatus = InputStatus.BASIC

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_common_input_basic,
            this,
            true
        )

        binding.inputValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                changeStatus(InputStatus.FOCUS)
            } else {
                changeStatus(InputStatus.BASIC)
            }
        }

        changeStatus(InputStatus.BASIC)

        if (attrs != null) {
            val style = context.obtainStyledAttributes(attrs, R.styleable.BasicInput)
            if (style.hasValue(R.styleable.BasicInput_android_label)) {
                val label = style.getText(R.styleable.BasicInput_android_label)
                binding.textLabel.text = label
            }

            if (style.hasValue(R.styleable.BasicInput_android_hint)) {
                val hint = style.getText(R.styleable.BasicInput_android_hint)
                binding.inputValue.hint = hint
            }

            if (style.hasValue(R.styleable.BasicInput_unit)) {
                val unit = style.getText(R.styleable.BasicInput_unit)
                binding.textUnit.text = unit
            }

            if (style.hasValue(R.styleable.BasicInput_subtext)) {
                val subtext = style.getText(R.styleable.BasicInput_subtext)
                binding.textSubText.text = subtext
            }

            if (style.hasValue(R.styleable.BasicInput_android_maxLength)) {
                val maxLength = style.getInt(R.styleable.BasicInput_android_maxLength, 10)
                binding.inputValue.filters = arrayOf(InputFilter.LengthFilter(maxLength))
            }

            if (style.hasValue(R.styleable.BasicInput_android_inputType)) {
                val inputType = style.getInt(
                    R.styleable.BasicInput_android_inputType,
                    EditorInfo.TYPE_TEXT_VARIATION_NORMAL
                )
                binding.inputValue.inputType = inputType
            }

            if (style.hasValue(R.styleable.BasicInput_android_imeOptions)) {
                val imeOptions = style.getInt(R.styleable.BasicInput_android_imeOptions, 0)
                binding.inputValue.imeOptions = imeOptions
            }

            if (style.hasValue(R.styleable.BasicInput_android_enabled)) {
                val enabled = style.getBoolean(R.styleable.BasicInput_android_enabled, true)
                isEnabled = enabled
            }
        }
    }

    override fun requestFocus(direction: Int, previouslyFocusedRect: Rect?): Boolean {
        binding.inputValue.showKeyboard()
        return binding.inputValue.requestFocus()
    }

    override fun setEnabled(enabled: Boolean) {
        binding.inputValue.isEnabled = enabled
        if (!enabled) {
            changeStatus(InputStatus.DISABLE)
        }
    }

    private fun changeStatus(status: InputStatus) {
        when (status) {
            InputStatus.BASIC -> {
                updateUIDesign(R.color.mono900, R.drawable.border_bottom_mono200_1dp)
            }
            InputStatus.FOCUS -> {
                updateUIDesign(R.color.emerald600, R.drawable.border_bottom_emerald600_2dp)
            }
            InputStatus.DISABLE -> {
                updateUIDesign(R.color.mono900, 0)
            }
            InputStatus.ERROR -> {
                updateUIDesign(R.color.red700, R.drawable.border_bottom_red700_2dp)
                binding.textErrorText.visibility = View.VISIBLE
                binding.textSubText.visibility = View.GONE
            }
        }
    }

    private fun updateUIDesign(labelColor: Int, inputBackground: Int) {
        binding.textLabel.setTextColor(ContextCompat.getColor(context, labelColor))
        binding.inputValue.setBackgroundResource(inputBackground)

        val haveSubText = binding.textSubText.text.isNullOrEmpty()
        binding.textSubText.visibility = if (haveSubText) View.GONE else View.VISIBLE
        binding.textErrorText.visibility = View.GONE
    }


    companion object {
        @JvmStatic
        @BindingAdapter(
            "value",
            "subtext",
            "errorText",
            requireAll = false
        )
        fun setData(
            view: BasicInput,
            value: String?,
            subtext: CharSequence?,
            errorText: CharSequence?
        ) {
            // databinding이 아닐경우 null로 들어오기떄문에 init에서 받는 결과값에 덮어씌여짐 - null 값은 무시 처리
            subtext?.let {
                view.binding.textSubText.text = it
            }

            val oldErrorText = view.binding.textErrorText.text.toString()
            if (oldErrorText != errorText && oldErrorText != null) {
                errorText?.let {
                    view.binding.textErrorText.text = it
                    view.changeStatus(InputStatus.ERROR)
                }
            }

            // two way binding
            val old = view.binding.inputValue.text.toString()
            if (old != value && value != null) {
                view.binding.inputValue.setText(value)
            }
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "value", event = "valueAttrChanged")
        fun getValue(view: BasicInput): String {
            return view.binding.inputValue.text.toString()
        }

        @JvmStatic
        @BindingAdapter("valueAttrChanged")
        fun setInverseBindingListener(view: BasicInput, listener: InverseBindingListener?) {
            val watcher = object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }

                override fun afterTextChanged(editable: Editable) {
                    if (view.currentStatus == InputStatus.ERROR) {
                        view.changeStatus(InputStatus.FOCUS)
                    }
                    listener?.onChange()
                }
            }
            view.binding.inputValue.addTextChangedListener(watcher)
        }
    }

}