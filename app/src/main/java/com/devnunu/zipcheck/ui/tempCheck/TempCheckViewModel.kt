package com.devnunu.zipcheck.ui.tempCheck

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.model.House
import com.devnunu.zipcheck.data.model.RoomTypeChecklist
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class TempCheckState(
    val house: House? = null,
    val currentPagerIndex: Int = 0
) {

    val filteredRoomTypeChecklist: List<RoomTypeChecklist>
        get() {
            val checklistNames = RoomTypeChecklist.getChecklist(house?.houseType)
            return house?.roomTypeChecklists?.filter { roomType ->
                checklistNames.contains(roomType.name)
            } ?: emptyList()
        }

    val selectedChecklist: RoomTypeChecklist?
        get() = house?.roomTypeChecklists?.getOrNull(currentPagerIndex)

    val description: String
        get() = when (selectedChecklist?.name) {
            RoomTypeChecklist.ENTRANCE.name ->
                "이제 집 안으로 들어가볼게요.\n현관 환경은 어떤가요?"
            RoomTypeChecklist.LIVING_AND_KITCHEN.name ->
                "거실과 부엌의 상태는 어떤가요?"
            RoomTypeChecklist.ROOM1.name ->
                "첫번째 방의 상태는 어떤가요?"
            RoomTypeChecklist.ROOM2.name ->
                "두번째 방의 상태는 어떤가요?"
            RoomTypeChecklist.BATHROOM.name ->
                "화장실의 상태는 어떤가요?"
            else -> ""
        }
}

class TempCheckViewModel(
    private val houseId: String,
    private val houseRepository: HouseRepository,
) : ContainerHost<TempCheckState, Nothing>, ViewModel() {

    override val container = container<TempCheckState, Nothing>(TempCheckState())

    init {
        intent {
            houseRepository.getHouseListFlow().collect { houseList ->
                val house = houseList.firstOrNull { it.id == houseId }
                reduce {
                    state.copy(
                        house = house
                    )
                }
            }
        }
    }

    fun onClickRoomType(roomTypeChecklist: RoomTypeChecklist) = intent {
        reduce {
            val index = state.house?.roomTypeChecklists?.indexOfFirst { roomType ->
                roomType.name == roomTypeChecklist.name
            } ?: 0
            state.copy(currentPagerIndex = index)
        }
    }

    fun onCheckChange(index: Int, isChecked: Boolean) = intent {
        val checklist = state.selectedChecklist?.checklist?.toMutableList()
        checklist?.getOrNull(index)?.isChecked = isChecked
        val selectedCheckList = state.selectedChecklist?.copy(
            checklist = checklist.orEmpty()
        )
        val roomTypeChecklists = state.house?.roomTypeChecklists?.map { roomType ->
            if (roomType.name == selectedCheckList?.name) {
                selectedCheckList
            } else {
                roomType
            }
        } ?: emptyList()
        val house = state.house?.copy(roomTypeChecklists = roomTypeChecklists)
        house?.let { house ->
            state.copy(house = house)
            houseRepository.updateHouse(house)
        }
    }
}