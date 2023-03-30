package com.devnunu.zipcheck.data.model.house

import com.devnunu.zipcheck.R

data class HouseOption(
    var optionName: String? = null,
    val isCustom: Boolean = false,
    var isSelected: Boolean = false,
) {

    val iconResId: Int
        get() = when (optionName) {
            "붙박이장" -> R.drawable.ic_option1
            "가스레인지\n/인덕션" -> R.drawable.ic_option2
            "세탁기" -> R.drawable.ic_option3
            "냉장고" -> R.drawable.ic_option4
            "전자레인지" -> R.drawable.ic_option5
            "비데" -> R.drawable.ic_option6
            "샤워부스" -> R.drawable.ic_option7
            else -> R.drawable.ic_option_custom
        }

    companion object {
        fun getEssentialOptionList(): List<HouseOption> = listOf(
            HouseOption("붙박이장"),
            HouseOption("가스레인지\n/인덕션"),
            HouseOption("세탁기"),
            HouseOption("냉장고"),
            HouseOption("전자레인지"),
            HouseOption("비데"),
            HouseOption("샤워부스"),
        )

        fun makeCustomHouseOption(optionName: String): HouseOption =
            HouseOption(
                optionName = optionName,
                isCustom = true,
                isSelected = true
            )
    }
}