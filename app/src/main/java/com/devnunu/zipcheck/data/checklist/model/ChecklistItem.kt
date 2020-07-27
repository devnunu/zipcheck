package com.devnunu.zipcheck.data.checklist.model

import java.util.*

class ChecklistItem {

    constructor(description: String) {
        this.description = description
    }

    var id: String = UUID.randomUUID().toString()
    var description: String = ""
    var isGood: Boolean? = null
}