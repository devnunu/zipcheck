package com.example.myapplication.ui.inputhouse

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.house.repo.HouseRepository
import javax.inject.Inject

class InputHouseViewModel@Inject constructor(
    private val houseRepository: HouseRepository
): ViewModel() {

}