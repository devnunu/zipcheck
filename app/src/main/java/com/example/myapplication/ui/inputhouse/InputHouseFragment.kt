package com.example.myapplication.ui.inputhouse

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.common.BaseFragment
import com.example.myapplication.databinding.FragmentInputChecklistBinding
import com.example.myapplication.databinding.FragmentInputHouseBinding
import com.example.myapplication.ui.inputchecklist.InputCheckListViewModel
import javax.inject.Inject

class InputHouseFragment : BaseFragment<FragmentInputHouseBinding, InputHouseViewModel>(
    R.layout.fragment_input_house,
    InputHouseViewModel::class
) {

    override fun setBindingVariables() {
        super.setBindingVariables()
    }

    override fun setEventObservers() {
        super.setEventObservers()
    }
}