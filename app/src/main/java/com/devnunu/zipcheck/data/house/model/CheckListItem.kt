package com.devnunu.zipcheck.data.house.model

import java.util.*

class CheckListItem {
    var id: String = UUID.randomUUID().toString()
    var description: String = ""
    var isChecked: Boolean = false
}