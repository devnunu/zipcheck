package com.devnunu.zipcheck.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.databinding.FragmentSplashBinding

class SplashFragment : BaseFragmentKoin<FragmentSplashBinding, ViewModel>(
    R.layout.fragment_splash,
    ViewModel::class.java
) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Handler().postDelayed({
            startNextActivity()
        },1500)
    }

    private fun startNextActivity() {
        val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        findNavController().navigate(action)
    }

}