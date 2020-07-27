package com.devnunu.zipcheck.ui.template

import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.databinding.FragmentInputChecklistTemplateBinding

class CheckListTemplateFragment :
    BaseFragment<FragmentInputChecklistTemplateBinding, CheckListTemplateViewModel>(
        R.layout.fragment_input_checklist_template,
        CheckListTemplateViewModel::class
    ) {

}