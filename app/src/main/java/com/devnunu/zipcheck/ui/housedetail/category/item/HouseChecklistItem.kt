package com.devnunu.zipcheck.ui.housedetail.category.item

import com.devnunu.zipcheck.data.checklist.model.CheckItem

class HouseChecklistItem(checklistItem: CheckItem, val index: Int) {
    val id = checklistItem.id
    val title = checklistItem.title
    val isGood: Boolean = checklistItem.isGood == true
    val isBad: Boolean = checklistItem.isGood == false
}