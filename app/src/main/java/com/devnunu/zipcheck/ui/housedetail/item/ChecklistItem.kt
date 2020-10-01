package com.devnunu.zipcheck.ui.housedetail.item

import com.devnunu.zipcheck.data.house.model.CheckItem

class ChecklistItem(checkItem: CheckItem) {
    val name = checkItem.name

    val point = checkItem.point
}