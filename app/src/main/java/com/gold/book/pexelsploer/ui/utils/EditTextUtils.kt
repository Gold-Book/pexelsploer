package com.gold.book.pexelsploer.ui.utils

import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.appcompat.widget.AppCompatEditText

fun AppCompatEditText.onSubmit(func: () -> Unit) {
    this.setOnEditorActionListener { _, actionId: Int, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) func.invoke()
        true
    }
}
