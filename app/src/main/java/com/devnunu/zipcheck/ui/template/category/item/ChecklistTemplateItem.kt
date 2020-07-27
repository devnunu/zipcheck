package com.devnunu.zipcheck.ui.template.category.item

import com.devnunu.zipcheck.data.checklist.model.ChecklistItem

class ChecklistTemplateItem(private val checklistItem: ChecklistItem) {
    val title = checklistItem.title
}