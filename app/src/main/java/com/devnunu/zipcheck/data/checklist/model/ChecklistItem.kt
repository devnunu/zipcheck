package com.devnunu.zipcheck.data.checklist.model

import java.util.*

class ChecklistItem {

    constructor(description: String) {
        this.title = description
    }

    var id: String = UUID.randomUUID().toString()
    var title: String = ""
    var isGood: Boolean? = null
}