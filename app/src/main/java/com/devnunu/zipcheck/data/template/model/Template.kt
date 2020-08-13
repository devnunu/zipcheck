package com.devnunu.zipcheck.data.template.model

class Checklist {

    var name: String? = ""
    var items: MutableMap<String, MutableList<CheckItem>>? = linkedMapOf()
}