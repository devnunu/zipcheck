package com.example.myapplication.ui.housedetail

import com.example.myapplication.R
import com.example.myapplication.common.BaseFragment
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentHouseDetailBinding
import com.example.myapplication.ui.home.HomeViewModel

class HouseDetailFragment : BaseFragment<FragmentHouseDetailBinding, HouseDetailViewModel>(
    R.layout.fragment_house_detail,
    HouseDetailViewModel::class.java
) {

}