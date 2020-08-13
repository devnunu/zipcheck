package com.devnunu.zipcheck.data.template.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devnunu.zipcheck.data.template.model.Template

class TemplateRepository {
    private val checklists = MutableLiveData<MutableList<Template>>()

    fun observeCheckLists(): LiveData<MutableList<Template>> {
        return checklists
    }

    fun saveChecklist(template: Template) {
        var newChecklists = checklists.value
        if (newChecklists.isNullOrEmpty()) {
            newChecklists = mutableListOf(template)
        } else {
            newChecklists.add(template)
        }
        checklists.value = newChecklists
    }
}