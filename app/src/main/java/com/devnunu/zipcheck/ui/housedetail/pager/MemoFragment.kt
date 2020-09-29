package com.devnunu.zipcheck.ui.housedetail.pager

import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.databinding.FragmentHouseDetailMemoBinding
import com.devnunu.zipcheck.ui.housedetail.HouseDetailViewModel

class MemoFragment : BaseFragmentKoin<FragmentHouseDetailMemoBinding, HouseDetailViewModel>(
    R.layout.fragment_house_detail_memo,
    HouseDetailViewModel::class.java
) {

    companion object {
        fun newInstance(): MemoFragment {
            return MemoFragment()
        }
    }
}