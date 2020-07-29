package com.devnunu.zipcheck.ui.inputtemplate.category

interface InputTemplateItemListener {
    fun onClickRemoveCategory(categoryName: String)
    fun onClickRemoveChecklistItem(categoryName: String, index: Int)
}