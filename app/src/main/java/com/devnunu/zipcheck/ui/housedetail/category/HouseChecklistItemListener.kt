package com.devnunu.zipcheck.ui.housedetail.category

interface HouseChecklistItemListener {
    fun onClickCheckItem(categoryName: String?, itemId: String?, isGood: Boolean?)
}