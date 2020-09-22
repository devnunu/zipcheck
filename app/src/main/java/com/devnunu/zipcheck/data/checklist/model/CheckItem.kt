package com.devnunu.zipcheck.data.checklist.model

import java.util.*

data class CheckItem(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    var isGood: Boolean = false
)
