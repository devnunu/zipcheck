package com.devnunu.zipcheck.ui.inputchecklist.item

import com.devnunu.zipcheck.data.checklist.model.Checklist

class TemplateItem(val checklist: Checklist, val index: Int, val isSelected:Boolean) {

    val name = checklist.name

    val itemCountText = "${checklist.items?.keys
        ?.mapNotNull {
            checklist.items?.get(it)?.size
        }
        ?.sumBy {
            it
        }}개"
}