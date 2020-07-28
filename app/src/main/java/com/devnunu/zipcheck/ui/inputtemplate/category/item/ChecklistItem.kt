package com.devnunu.zipcheck.ui.inputtemplate.category.item

import com.devnunu.zipcheck.data.checklist.model.CheckItem

class ChecklistItem(private val checklistItem: CheckItem) {
    val title = checklistItem.title
}