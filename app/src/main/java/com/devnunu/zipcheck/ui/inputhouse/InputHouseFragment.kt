package com.devnunu.zipcheck.ui.inputhouse

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.databinding.FragmentInputHouseBinding

class InputHouseFragment : BaseFragmentKoin<FragmentInputHouseBinding, InputHouseViewModel>(
    R.layout.fragment_input_house,
    InputHouseViewModel::class.java
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }
            val items = listOf(
                HouseType.LEASE_RENT.displayName,
                HouseType.LEASE_MONTHLY_PAY.displayName,
                HouseType.TRADE.displayName
            )
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
            (it.inputHouseType.editText as? AutoCompleteTextView)?.setAdapter(adapter)
            it.inputHouseType.editText?.addTextChangedListener {
                viewModel.onChangeHouseType()
            }
        }
    }

    override fun setEventObservers() {
        viewModel.onSuccessRegisterHouse.observe(this, EventObserver {
            showToast("집이 등록되었습니다!")
            val action = InputHouseFragmentDirections.actionInputHouseFragmentToHomeFragment()
            findNavController().navigate(action)
        })
    }
}