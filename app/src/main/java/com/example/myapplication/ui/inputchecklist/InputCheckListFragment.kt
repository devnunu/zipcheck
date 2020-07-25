package com.example.myapplication.ui.inputchecklist

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.common.BaseFragment
import com.example.myapplication.databinding.FragmentHouseDetailBinding
import com.example.myapplication.databinding.FragmentInputChecklistBinding
import com.example.myapplication.ui.housedetail.HouseDetailViewModel
import javax.inject.Inject

class InputCheckListFragment : BaseFragment<FragmentInputChecklistBinding, InputCheckListViewModel>(
    R.layout.fragment_input_checklist,
    InputCheckListViewModel::class
) {
}