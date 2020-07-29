package com.devnunu.zipcheck.ui.housedetail

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import javax.inject.Inject

class HouseDetailViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {
}