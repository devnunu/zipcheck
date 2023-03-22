package com.devnunu.zipcheck.data.model.house

data class HouseBenefit(
    val text: String,
    val isSelected: Boolean = false
) {
    companion object {
        fun getEssentialBenefitList(): List<HouseBenefit> = listOf(
            HouseBenefit(text = "#채광이 좋아요 \uD83C\uDF1E"),
            HouseBenefit(text = "#집이 넓어요 \uD83C\uDFE0"),
            HouseBenefit(text = "#옵션이 마음에들어요 \uD83D\uDECB"),
            HouseBenefit(text = "#깨끗해요 ✨"),
            HouseBenefit(text = "#최근에 짓거나 리모델링했어요 \uD83C\uDD95")
        )
    }
}