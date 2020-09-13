package com.devnunu.zipcheck.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseFragmentKoin<T : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutId: Int,
    viewModelClass: Class<VM>
) : Fragment() {

    protected lateinit var binding: T

    val viewModel: VM by viewModel(viewModelClass.kotlin)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        setBindingVariables()
        setEventObservers()
        return binding.root
    }

    open fun setBindingVariables() {}

    open fun setEventObservers() {}
}