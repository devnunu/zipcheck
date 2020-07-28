package com.devnunu.zipcheck.data.checklist.model

class Checklist {

    val name: String = ""
    var items: Map<String, List<CheckItem>> = hashMapOf()

    fun resetToDefaultItems(typeList: List<ChecklistType?>) {
        val map = linkedMapOf<String, List<CheckItem>>()
        typeList.filterNotNull().forEach { checklistType ->
            map[checklistType.displayName] = getDefaultChecklist(checklistType)
        }
        items = map
    }

    private fun getDefaultChecklist(checklistType: ChecklistType?): List<CheckItem> {
        return when (checklistType) {
            ChecklistType.CHECKLIST_TYPE_HOUSE -> getChecklistHouse()
            ChecklistType.CHECKLIST_TYPE_CIRCUMSTANCE -> getChecklistCircumstance()
            else -> listOf<CheckItem>()
        }
    }

    private fun getChecklistHouse(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("관리비가 있나요"))
            add(CheckItem("전기와 수도계량기를 세대별로 사용하나요"))
            add(CheckItem("임대인이 같은 건물에 거주하나요"))
            add(CheckItem("전세 자금 대출이 가능한가요"))
            add(CheckItem("근저당 설정된 집인가요"))
        }
    }

    private fun getChecklistCircumstance(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("주변 치안상태는 좋은가요"))
            add(CheckItem("교통 및 편의 시설은 가까운가요"))
            add(CheckItem("주변에 소음이 있나요"))
            add(CheckItem("관리실이 있나요"))
            add(CheckItem("택배 수령하는 방법이 편리한가요"))
            add(CheckItem("쓰레기 배출장소는 가까운가요"))
            add(CheckItem("방범시설이 있나요"))
        }
    }
}

enum class ChecklistType(val displayName: String) {
    CHECKLIST_TYPE_HOUSE("입주"),
    CHECKLIST_TYPE_CIRCUMSTANCE("주변시설"),
    CHECKLIST_TYPE_EXTERIOR("외부환경"),
    CHECKLIST_TYPE_ENTRANCE("현관"),
    CHECKLIST_TYPE_MAIN_ROOM("안방/거실"),
    CHECKLIST_TYPE_KITCHEN("주방"),
    CHECKLIST_TYPE_VERANDA("베란다"),
    CHECKLIST_TYPE_ETC("기타"),
    CHECKLIST_TYPE_USER_CUSTOM("내가 추가한 목록");

    companion object {
        fun fromDisplayName(text: String?): ChecklistType? {
            ChecklistType.values().forEach { checklistType ->
                if (checklistType.displayName.equals(text, ignoreCase = true)) {
                    return checklistType
                }
            }
            return null
        }
    }
}