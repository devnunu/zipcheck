package com.example.myapplication.ui.splash

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.house.repo.HouseRepository
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

}