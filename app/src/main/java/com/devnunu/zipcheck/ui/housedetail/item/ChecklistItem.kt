package com.devnunu.zipcheck.ui.housedetail.item

import com.devnunu.zipcheck.data.template.model.CheckItem

class ChecklistItem(checkItem: CheckItem) {

    val id = checkItem.id

    val name = checkItem.name

    val isGood = checkItem.isGood?.let {
        it
    } ?: false

    val isBad = checkItem.isGood?.let {
        !it
    } ?: false
}