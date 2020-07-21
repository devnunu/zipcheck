package com.example.myapplication.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.home.HomeViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseFragment<T : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutId: Int,
    private val viewModelClass: Class<VM>
) : Fragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        setBindingVariables()
        setEventObservers()
        return binding.root
    }

    open fun setBindingVariables() {}

    open fun setEventObservers() {}
}