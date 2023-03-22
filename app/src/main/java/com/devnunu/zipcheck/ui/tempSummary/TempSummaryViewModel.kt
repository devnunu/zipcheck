package com.devnunu.zipcheck.ui.tempSummary

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.model.house.House
import com.devnunu.zipcheck.data.model.house.HouseBenefit
import com.devnunu.zipcheck.data.model.house.HouseWriteStatus
import com.devnunu.zipcheck.data.model.house.Summary
import com.devnunu.zipcheck.data.repository.HouseRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class TempSummaryState(
    val house: House? = null,
    val selectedSummary: Summary? = null,
    val houseBenefitList: List<HouseBenefit> = emptyList(),
)

class TempSummaryViewModel(
    private val houseId: String,
    private val houseRepository: HouseRepository,
) : ContainerHost<TempSummaryState, Nothing>, ViewModel() {

    override val container = container<TempSummaryState, Nothing>(TempSummaryState())

    init {
        intent {
            houseRepository.getHouseListFlow().collect { houseList ->
                val house = houseList.firstOrNull { it.id == houseId }
                reduce {
                    state.copy(
                        house = house,
                        houseBenefitList = house?.benefitList.orEmpty()
                    )
                }
            }
        }
    }

    fun onClickSummary(summary: Summary) = intent {
        reduce {
            state.copy(selectedSummary = summary)
        }
    }

    fun onClickHouseBenefit(clickedHouseBenefit: HouseBenefit) = intent {
        val houseBenefitList = state.houseBenefitList.toMutableList().map { houseBenefit ->
            if (houseBenefit == clickedHouseBenefit) {
                houseBenefit.copy(isSelected = !houseBenefit.isSelected)
            } else {
                houseBenefit
            }
        }
        reduce {
            state.copy(houseBenefitList = houseBenefitList)
        }
    }

    fun onClickSave(
        onSuccess: () -> Unit
    ) = intent {
        var house = state.house?.copy(
            summary = state.selectedSummary,
            benefitList = state.houseBenefitList
        )
        if (state.selectedSummary == Summary.BAD) {
            house = house?.copy(houseWriteStatus = HouseWriteStatus.FAIL)
        }
        house?.let { house ->
            houseRepository.updateHouse(house)
            onSuccess()
        }
    }
}