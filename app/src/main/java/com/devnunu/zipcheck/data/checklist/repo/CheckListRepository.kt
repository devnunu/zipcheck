package com.devnunu.zipcheck.data.checklist.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devnunu.zipcheck.data.checklist.model.Checklist

class CheckListRepository {
    private val checkLists = MutableLiveData<List<Checklist>>()

    fun observeCheckLists(): LiveData<List<Checklist>> {
        return checkLists
    }
}