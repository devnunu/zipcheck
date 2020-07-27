package com.devnunu.zipcheck.ui.template.category

import com.devnunu.zipcheck.data.checklist.model.ChecklistItem
import com.devnunu.zipcheck.ui.template.category.item.ChecklistTemplateItem


class CategoryItem(
    val categoryName: String,
    val checklistTemplateItems: List<ChecklistItem>?
) {

}