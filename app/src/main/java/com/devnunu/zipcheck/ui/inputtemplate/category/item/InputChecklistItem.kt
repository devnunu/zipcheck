package com.devnunu.zipcheck.ui.inputtemplate.category.item

import com.devnunu.zipcheck.data.checklist.model.CheckItem

class InputChecklistItem(checklistItem: CheckItem, val index: Int) {
    val title = checklistItem.title
}