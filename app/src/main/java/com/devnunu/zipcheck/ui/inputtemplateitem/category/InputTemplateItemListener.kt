package com.devnunu.zipcheck.ui.inputtemplateitem.category

import com.devnunu.zipcheck.data.template.model.CheckItem

interface InputTemplateItemListener {
    fun onChangeCheckItems(checkItems: MutableList<CheckItem>)
}