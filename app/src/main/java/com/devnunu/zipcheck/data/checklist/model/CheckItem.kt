package com.devnunu.zipcheck.data.checklist.model

import java.util.*

class CheckItem {

    constructor(name: String) {
        this.name = name
    }

    var id: String = UUID.randomUUID().toString()
    var name: String = ""
    var isGood: Boolean? = null
}