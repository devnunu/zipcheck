package com.devnunu.zipcheck.ui.tempCheck

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.model.house.Checklist
import com.devnunu.zipcheck.data.model.house.House
import com.devnunu.zipcheck.data.model.house.RoomType
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class TempCheckState(
    val house: House? = null,
    val currentPagerIndex: Int = 0
) {

    val roomTypeList: List<RoomType>
        get() = RoomType.getRoomTypes(house?.houseType)

    val selectedRoomType: RoomType?
        get() = roomTypeList.getOrNull(currentPagerIndex)

    val selectedChecklist: List<String>
        get() = house?.checklist?.getChecklist(selectedRoomType) ?: emptyList()

    val plainChecklist: List<String>
        get() = Checklist.getPlainChecklist(selectedRoomType)

    val description: String
        get() = when (selectedRoomType) {
            RoomType.ENTRANCE ->
                "이제 집 안으로 들어가볼게요.\n현관 환경은 어떤가요?"
            RoomType.LIVING_AND_KITCHEN ->
                "거실과 부엌의 상태는 어떤가요?"
            RoomType.ROOM1 ->
                "첫번째 방의 상태는 어떤가요?"
            RoomType.ROOM2 ->
                "두번째 방의 상태는 어떤가요?"
            RoomType.BATHROOM ->
                "화장실의 상태는 어떤가요?"
            else -> ""
        }
}

class TempCheckViewModel(
    private val houseId: Long,
    private val houseRepository: HouseRepository,
) : ContainerHost<TempCheckState, Nothing>, ViewModel() {

    override val container = container<TempCheckState, Nothing>(TempCheckState())

    init {
        collectDataFlow()
    }

    private fun collectDataFlow() = intent {
        houseRepository.getHouseFlow(houseId).collect { house ->
            reduce {
                state.copy(house = house)
            }
        }
    }

    fun onClickRoomType(clickedRoomType: RoomType) = intent {
        reduce {
            val index = state.roomTypeList.indexOfFirst { roomType ->
                roomType == clickedRoomType
            }
            state.copy(currentPagerIndex = index)
        }
    }

    fun onCheckChange(item: String) = intent {
        val selectedChecklist = state.selectedChecklist.toMutableList()
        if (selectedChecklist.contains(item)) {
            selectedChecklist.remove(item)
        } else {
            selectedChecklist.add(item)
        }
        val checklist: Checklist = state.house?.checklist ?: Checklist()
        var changedChecklist = Checklist()
        when (state.selectedRoomType) {
            RoomType.ENTRANCE -> {
                changedChecklist = checklist.copy(entranceChecklists = selectedChecklist)
            }
            RoomType.LIVING_AND_KITCHEN -> {
                changedChecklist = checklist.copy(livingAndKitchenChecklists = selectedChecklist)
            }
            RoomType.ROOM1 -> {
                changedChecklist = checklist.copy(room1Checklists = selectedChecklist)
            }
            RoomType.ROOM2 -> {
                changedChecklist = checklist.copy(room2Checklist = selectedChecklist)
            }
            RoomType.BATHROOM -> {
                changedChecklist = checklist.copy(bathRoomChecklist = selectedChecklist)
            }
            else -> Unit
        }
        val house = state.house?.copy(checklist = changedChecklist)
        house?.let { house ->
            houseRepository.updateHouse(house)
        }
    }
}