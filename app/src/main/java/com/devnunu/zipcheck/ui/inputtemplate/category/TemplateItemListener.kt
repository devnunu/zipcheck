package com.devnunu.zipcheck.ui.inputtemplate.category

interface TemplateItemListener {
    fun onClickRemoveCategory(categoryName: String)
    fun onClickRemoveChecklistItem(categoryName: String, index: Int)
}