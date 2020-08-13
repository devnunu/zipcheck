package com.devnunu.zipcheck.ui.inputtemplate.item

import com.devnunu.zipcheck.data.template.model.Template

class TemplateItem(val template: Template, val index: Int, val isSelected:Boolean) {

    val name = template.name

    val itemCountText = "체크리스트 갯수 : 0개"
}