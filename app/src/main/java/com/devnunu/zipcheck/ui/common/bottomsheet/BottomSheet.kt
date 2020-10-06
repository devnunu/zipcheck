package com.devnunu.zipcheck.ui.common.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutBottomSheetListBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList

class BottomSheet(
    private val items: ArrayList<String>,
    private val listener: BottomSheetListener
) : BottomSheetDialogFragment() {

    private var binding: LayoutBottomSheetListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_bottom_sheet_list,
            container,
            false
        )
        setBindingVariables()
        setIntroItemAdapter()
        return binding?.root
    }

    private fun setBindingVariables() {
        binding?.also {
            it.items = items
            it.listener = object : BottomSheetListener {
                override fun onItemClick(title: String?) {
                    listener.onItemClick(title)
                    dismiss()
                }
            }
        }
    }

    private fun setIntroItemAdapter() {
        binding?.bottomSheetItemList?.adapter = BottomSheetItemAdapter()
    }

}