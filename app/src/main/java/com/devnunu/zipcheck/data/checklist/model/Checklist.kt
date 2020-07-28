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
            ChecklistType.CHECKLIST_TYPE_EXTERIOR -> getChecklistExterior()
            ChecklistType.CHECKLIST_TYPE_ENTRANCE -> getChecklistEntrance()
            ChecklistType.CHECKLIST_TYPE_MAIN_ROOM -> getChecklistMainRoom()
            ChecklistType.CHECKLIST_TYPE_BATHROOM -> getChecklistBathRoom()
            ChecklistType.CHECKLIST_TYPE_KITCHEN -> getChecklistKitchen()
            ChecklistType.CHECKLIST_TYPE_VERANDA -> getChecklistVeranda()
            ChecklistType.CHECKLIST_TYPE_OPTION -> getChecklistOption()
            else -> listOf()
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

    private fun getChecklistExterior(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("관리실이 있나요?"))
            add(CheckItem("택배 수령하는 방법이 편리한가요?"))
            add(CheckItem("쓰레기 배출 장소는 가까운가요?"))
            add(CheckItem("방범시설이 있나요?"))
        }
    }

    private fun getChecklistEntrance(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("현관 잠금장치가 잘 되어있나요?"))
            add(CheckItem("신발장을 놓을 공간 혹은 신발장이 있나요?"))
        }
    }

    private fun getChecklistMainRoom(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("문은 모두 잘 열리고 닫히나요?"))
            add(CheckItem("창문의 상태가 양호한가요?"))
            add(CheckItem("창문마다 방충망과 방범창이 있나요?"))
            add(CheckItem("구석에 곰팡이의 흔적이 있나요?"))
            add(CheckItem("전기 콘센트의 상태가 양호한가요?"))
            add(CheckItem("벽지나 장판의 들뜸이 있나요?"))
            add(CheckItem("층간 소음이 있나요?"))
        }
    }

    private fun getChecklistKitchen(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("주방 시설의 상태가 양호한가요?"))
            add(CheckItem("수압 및 이물질, 배수의 상태는 양호한가요?"))
            add(CheckItem("싱크대가 넓나요?"))
            add(CheckItem("싱크대 하단이나 벽에 누수의 흔적이 있나요?"))
        }
    }

    private fun getChecklistBathRoom(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("욕실 시설의 상태가 양호한가요?"))
            add(CheckItem("수압 및 이물질, 배수상태는 양호한가요?"))
            add(CheckItem("욕실에 환기를 위한 환풍기나 창문이 있나요?"))
        }
    }

    private fun getChecklistVeranda(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("주변 건물과의 간격은 적당한가요?"))
            add(CheckItem("베란다 시설의 상태가 양호한가요?"))
            add(CheckItem("수압 및 이물질, 배수 상태는 양호한가요?"))
            add(CheckItem("보일러 상태와 난방은 양호한가요?"))
        }
    }

    private fun getChecklistOption(): List<CheckItem> {
        return mutableListOf<CheckItem>().apply {
            add(CheckItem("주차가 가능한가요?"))
            add(CheckItem("반려동물과 함께 거주 가능한가요?"))
            add(CheckItem("기본 옵션이 있나요?"))
            add(CheckItem("엘리베이터 기능이 있나요?"))
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
    CHECKLIST_TYPE_BATHROOM("주방"),
    CHECKLIST_TYPE_VERANDA("베란다"),
    CHECKLIST_TYPE_OPTION("옵션"),
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