package com.devnunu.zipcheck.ui.splash

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

}