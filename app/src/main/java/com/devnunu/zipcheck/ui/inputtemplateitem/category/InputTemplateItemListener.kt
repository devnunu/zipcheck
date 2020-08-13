package com.devnunu.zipcheck.ui.inputtemplateitem.category

interface InputTemplateItemListener {
    fun onClickAddCategoryItem(categoryName: String)
    fun onClickRemoveCategory(categoryName: String)
    fun onClickRemoveChecklistItem(categoryName: String, index: Int)
}