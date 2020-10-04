package com.devnunu.zipcheck.ui.housedetail.photoslider

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.FragmentCommonPhotoSliderBinding

class PhotoSliderFragment(
    private val uri: Uri
) : Fragment() {

    private lateinit var binding: FragmentCommonPhotoSliderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_common_photo_slider,
            container,
            false
        )
        binding.lifecycleOwner = this
        setBindingVariables()
        return binding.root
    }

    private fun setBindingVariables() {
        binding.imageView.setImageURI(uri)
    }
}