package com.example.myapplication.ui.inputhouse

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
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
        binding.also {
            it.viewModel = viewModel
            val items = listOf("전세", "월세", "매매")
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
            (it.inputHouseType.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        }
    }

    override fun setEventObservers() {
        super.setEventObservers()
    }
}