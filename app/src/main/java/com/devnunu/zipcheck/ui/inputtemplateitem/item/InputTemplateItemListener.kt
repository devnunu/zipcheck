package com.devnunu.zipcheck.ui.inputtemplateitem.item

import com.devnunu.zipcheck.data.checklist.model.CheckItem

interface InputTemplateItemListener {
    fun onChangeCheckItems(checkItems: MutableList<CheckItem>)
}