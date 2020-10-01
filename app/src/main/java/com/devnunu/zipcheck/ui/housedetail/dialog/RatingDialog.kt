package com.devnunu.zipcheck.ui.housedetail.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import androidx.fragment.app.DialogFragment
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutCommonDialogRatingBinding
import com.devnunu.zipcheck.ui.housedetail.HouseDetailViewModel

class RatingDialog(
    val index: Int,
    val point: Int,
    val viewModel: HouseDetailViewModel
) : DialogFragment() {

    private lateinit var binding: LayoutCommonDialogRatingBinding

    private var inputPoint: ObservableInt = ObservableInt(point)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_common_dialog_rating,
            container,
            false
        )
        setBindingVariables()
        return binding.root
    }

    private fun setBindingVariables() {
        binding.also {
            it.index = index
            it.point = inputPoint
            it.dialog = this
        }
    }

    fun onClickStar(point: Int) {
        inputPoint.set(point)
    }

    fun onClickPositiveBtn() {
        viewModel.onClickRate(index, inputPoint.get())
    }

    fun onClickNegativeBtn() {
        viewModel.onClickRate(index, 0)
    }

}