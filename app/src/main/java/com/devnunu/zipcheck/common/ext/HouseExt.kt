package com.devnunu.zipcheck.common.ext

import com.devnunu.zipcheck.data.house.model.House

inline val House.filteredAveragePoint: Int
    get() {
        val filteredList = checklist.filter { it.point != 0 }
        return if (filteredList.isEmpty()) 0
        else filteredList.map { it.point }.sum().div(filteredList.size)
    }