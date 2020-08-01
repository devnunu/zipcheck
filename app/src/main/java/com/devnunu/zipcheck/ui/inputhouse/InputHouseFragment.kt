package com.devnunu.zipcheck.ui.inputhouse

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.databinding.FragmentInputChecklistBinding
import com.devnunu.zipcheck.databinding.FragmentInputHouseBinding

class InputHouseFragment : BaseFragment<FragmentInputHouseBinding, InputHouseViewModel>(
    R.layout.fragment_input_house,
    InputHouseViewModel::class
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().navigateUp() }
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