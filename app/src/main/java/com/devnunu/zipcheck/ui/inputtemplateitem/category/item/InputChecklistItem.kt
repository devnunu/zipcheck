package com.devnunu.zipcheck.ui.inputtemplateitem.category.item

import com.devnunu.zipcheck.data.template.model.CheckItem

class InputChecklistItem(checklistItem: CheckItem, val index: Int) {
    val title = checklistItem.title
}