package com.example.myapplication.ui.inputchecklist

import com.example.myapplication.R
import com.example.myapplication.common.BaseFragment
import com.example.myapplication.databinding.FragmentHouseDetailBinding
import com.example.myapplication.databinding.FragmentInputChecklistBinding
import com.example.myapplication.ui.housedetail.HouseDetailViewModel

class InputCheckListFragment : BaseFragment<FragmentInputChecklistBinding, InputCheckListViewModel>(
    R.layout.fragment_input_checklist,
    InputCheckListViewModel::class.java
) {

}