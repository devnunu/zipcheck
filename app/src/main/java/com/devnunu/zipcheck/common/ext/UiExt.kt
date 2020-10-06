package com.devnunu.zipcheck.common.ext

import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun EditText.showKeyboard() {
    postDelayed({
        val keyboard =
            context.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.showSoftInput(this, 0)
    }, 400)
}