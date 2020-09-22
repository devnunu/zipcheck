package com.devnunu.zipcheck.data.checklist.model

data class Checklist(
    val id: Int? = null,
    val name: String,
    val items: List<CheckItem>
)