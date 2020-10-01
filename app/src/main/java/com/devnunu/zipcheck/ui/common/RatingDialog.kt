package com.devnunu.zipcheck.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutCommonDialogRatingBinding

class RatingDialog(
    val index: Int,
    val listener: RatingDialogListener
) : DialogFragment() {

    private lateinit var binding: LayoutCommonDialogRatingBinding

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
            it.listener = listener
        }
    }

}