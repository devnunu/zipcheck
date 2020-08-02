package com.devnunu.zipcheck.ui.inputtemplate.category

interface InputTemplateItemListener {
    fun onClickAddCategoryItem(categoryName: String)
    fun onClickRemoveCategory(categoryName: String)
    fun onClickRemoveChecklistItem(categoryName: String, index: Int)
}