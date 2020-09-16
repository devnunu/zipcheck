package com.devnunu.zipcheck.ui.inputtemplate.item

import com.devnunu.zipcheck.data.template.model.Checklist

class TemplateItem(val checklist: Checklist, val index: Int, val isSelected: Boolean) {

    val name = checklist.name

    val itemCountText = "체크리스트 갯수 : ${checklist.items.size}개"
}