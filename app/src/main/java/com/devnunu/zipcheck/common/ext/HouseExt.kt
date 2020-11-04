package com.devnunu.zipcheck.common.ext

import com.devnunu.zipcheck.data.house.model.House

inline val House.filteredAveragePoint: Double
    get() {
        val filteredList = checklist.filter { it.point != 0 }
        return if (filteredList.isEmpty()) 0.0
        else {
            val sumResult = filteredList.map { it.point }.sum().toDouble()
            sumResult / filteredList.size
        }
    }