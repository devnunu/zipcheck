package com.devnunu.zipcheck.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devnunu.zipcheck.common.ext.assistedViewModels
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutId: Int,
    viewModelClass: KClass<VM>
) : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    protected val viewModel: VM by assistedViewModels(viewModelClass) { viewModelFactory }

    protected lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setBindingVariables()
        setEventObservers()
    }

    open fun setBindingVariables() {}

    open fun setEventObservers() {}
}