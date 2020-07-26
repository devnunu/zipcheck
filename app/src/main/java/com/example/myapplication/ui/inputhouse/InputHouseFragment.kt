package com.example.myapplication.ui.inputhouse

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.common.BaseFragment
import com.example.myapplication.common.EventObserver
import com.example.myapplication.data.house.model.HouseType
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
            val items = listOf(
                HouseType.LEASE_RENT.displayName,
                HouseType.LEASE_MONTHLY_PAY.displayName,
                HouseType.TRADE.displayName
            )
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
            (it.inputHouseType.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        }
    }

    override fun setEventObservers() {
        viewModel.onClickNextBtn.observe(this, EventObserver {
            val action =
                InputHouseFragmentDirections.actionInputHouseFragmentToInputCheckListFragment()
            findNavController().navigate(action)
        })
    }
}