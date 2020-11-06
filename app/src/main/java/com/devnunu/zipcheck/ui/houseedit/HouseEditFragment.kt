package com.devnunu.zipcheck.ui.houseedit

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.data.house.model.HouseType
import com.devnunu.zipcheck.data.house.model.TransactionType
import com.devnunu.zipcheck.databinding.FragmentHouseEditBinding
import com.devnunu.zipcheck.ui.common.bottomsheet.BottomSheet
import com.devnunu.zipcheck.ui.common.bottomsheet.BottomSheetListener
import com.devnunu.zipcheck.ui.housedetail.HouseDetailFragmentArgs

class HouseEditFragment : BaseFragmentKoin<FragmentHouseEditBinding, HouseEditViewModel>(
    R.layout.fragment_house_edit,
    HouseEditViewModel::class.java
) {

    private val arg: HouseEditFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arg.houseId.let {
            viewModel.start(it)
        }
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
        }
    }

    override fun setEventObservers() {

        viewModel.onClickParking.observe(this, EventObserver {
            val items = arrayListOf(
                "가능", "불가능"
            )
            val bottomSheet = BottomSheet(items, object : BottomSheetListener {
                override fun onItemClick(title: String?) {
                    viewModel.setParking(title)
                }
            })
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        })

        viewModel.onClickElevator.observe(this, EventObserver {
            val items = arrayListOf(
                "있음", "없음"
            )
            val bottomSheet = BottomSheet(items, object : BottomSheetListener {
                override fun onItemClick(title: String?) {
                    viewModel.setElevator(title)
                }
            })
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        })

        viewModel.onClickHouseType.observe(this, EventObserver {
            val items = arrayListOf(
                HouseType.MULTI_FAMILY_HOUSE.displayName,
                HouseType.MULTI_HOUSE_HOLE.displayName,
                HouseType.DETACHED_HOUSE.displayName,
                HouseType.OFFICE_TEL.displayName,
                HouseType.APARTMENT.displayName
            )
            val bottomSheet = BottomSheet(items, object : BottomSheetListener {
                override fun onItemClick(title: String?) {
                    viewModel.setHouseType(title)
                }
            })
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        })
    }
}