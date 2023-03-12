package com.devnunu.zipcheck.data.model

import androidx.annotation.DrawableRes
import com.devnunu.zipcheck.R

data class HouseOption(
    var optionName: String,
    @DrawableRes val iconRedId: Int,
    var selected: Boolean = false,
    val isCustom: Boolean = false,
) {

    companion object {
        fun getEssentialOptionList(): List<HouseOption> = listOf(
            HouseOption("붙박이장", R.drawable.ic_option1),
            HouseOption("가스레인지\n/인덕션", R.drawable.ic_option2),
            HouseOption("세탁기", R.drawable.ic_option3),
            HouseOption("냉장고", R.drawable.ic_option4),
            HouseOption("전자레인지", R.drawable.ic_option5),
            HouseOption("비데", R.drawable.ic_option6),
            HouseOption("샤워부스", R.drawable.ic_option7),
        )
    }
}