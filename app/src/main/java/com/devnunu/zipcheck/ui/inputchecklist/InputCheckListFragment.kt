package com.devnunu.zipcheck.ui.inputchecklist

import android.view.View
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHouseDetailBinding
import com.devnunu.zipcheck.databinding.FragmentInputChecklistBinding
import com.devnunu.zipcheck.ui.inputchecklist.item.TemplateItemAdapter

class InputCheckListFragment : BaseFragment<FragmentInputChecklistBinding, InputCheckListViewModel>(
    R.layout.fragment_input_checklist,
    InputCheckListViewModel::class
) {

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().navigateUp() }
            it.listChecklistTemplate.adapter = TemplateItemAdapter(viewModel)
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddTemplateBtn.observe(this, EventObserver {
            val action =
                InputCheckListFragmentDirections.actionInputCheckListFragmentToCheckListTemplateFragment()
            findNavController().navigate(action)
        })

        viewModel.onSuccessSubmitHouse.observe(this, EventObserver {
//            val action =
//                InputCheckListFragmentDirections.actionInputCheckListFragmentToHomeFragment()
//            findNavController().navigate(action)
        })
    }
}