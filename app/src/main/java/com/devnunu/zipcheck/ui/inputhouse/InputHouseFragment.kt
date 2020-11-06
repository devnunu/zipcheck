package com.devnunu.zipcheck.ui.inputhouse

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.MainActivity
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.data.house.model.TransactionType
import com.devnunu.zipcheck.databinding.FragmentInputHouseBinding
import com.devnunu.zipcheck.ui.common.bottomsheet.BottomSheet

class InputHouseFragment : BaseFragmentKoin<FragmentInputHouseBinding, InputHouseViewModel>(
    R.layout.fragment_input_house,
    InputHouseViewModel::class.java
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
        }
    }

    override fun setEventObservers() {
        viewModel.onSuccessRegisterHouse.observe(this, EventObserver {
            showToast("집이 등록되었습니다!")
            val action = InputHouseFragmentDirections.actionInputHouseFragmentToHomeFragment()
            findNavController().navigate(action)
        })

        viewModel.onClickHouseType.observe(this, EventObserver {
            val items = arrayListOf(
                TransactionType.LEASE_RENT.displayName,
                TransactionType.LEASE_MONTHLY_PAY.displayName,
                TransactionType.TRADE.displayName
            )
            val bottomSheet = BottomSheet(
                items,
                viewModel
            )
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.resetViewModelLiveData()
    }
}