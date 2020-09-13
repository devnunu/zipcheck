package com.devnunu.zipcheck.common

import android.R
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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

    fun showToast(message: String?) {
        val toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
        val tv = toast.view.findViewById<TextView>(R.id.message)
        if (tv != null) {
            tv.gravity = Gravity.CENTER
            tv.textSize = 14f
        }
        toast.show()
    }
}