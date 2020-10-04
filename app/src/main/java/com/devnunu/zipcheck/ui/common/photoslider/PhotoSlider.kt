package com.devnunu.zipcheck.ui.common.photoslider

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.viewpager2.widget.ViewPager2
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.databinding.LayoutCommonPhotoSliderBinding
import com.google.android.material.tabs.TabLayoutMediator

class PhotoSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val binding: LayoutCommonPhotoSliderBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_common_photo_slider,
            this,
            true
        )
        setBindingVariables()

    }

    private fun setBindingVariables() {
        binding.apply {
            viewpager.adapter = PhotoSliderAdapter()
            viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    val currentPage = position + 1
                    binding.textImgSize.text = "$currentPage/"
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
            viewpager.isSaveEnabled = false
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(
            "uriList",
            "onClickAddPhoto",
            requireAll = false
        )
        fun setData(
            view: PhotoSlider,
            uriList: List<Uri>?,
            onClickAddPhoto: OnClickListener?
        ) {
            uriList?.let {
                view.binding.viewpager.visibility = View.VISIBLE
                view.binding.textNote.visibility = View.GONE
                val adapter = view.binding.viewpager.adapter as PhotoSliderAdapter
                adapter.setItem(it)
            }

            onClickAddPhoto?.let {
                view.binding.btnAddPhoto.setOnClickListener(it)
            }
        }
    }
}