package com.devnunu.zipcheck.ui.template

import androidx.lifecycle.ViewModel
import com.devnunu.zipcheck.data.house.repo.HouseRepository
import javax.inject.Inject

class CheckListTemplateViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {

}