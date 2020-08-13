package com.devnunu.zipcheck.ui.inputtemplateitem.item

import com.devnunu.zipcheck.data.template.model.CheckItem

interface InputTemplateItemListener {
    fun onChangeCheckItems(checkItems: MutableList<CheckItem>)
}