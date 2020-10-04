package com.devnunu.zipcheck.ui.housedetail

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHouseDetailBinding
import com.devnunu.zipcheck.ui.housedetail.pager.HouseDetailPagerAdapter
import com.devnunu.zipcheck.ui.housedetail.photoslider.PhotoSliderAdapter
import com.google.android.material.tabs.TabLayoutMediator


class HouseDetailFragment : BaseFragmentKoin<FragmentHouseDetailBinding, HouseDetailViewModel>(
    R.layout.fragment_house_detail,
    HouseDetailViewModel::class.java
) {

    companion object {
        const val REQUEST_CODE_SELECT_PICTURES = 30828
    }

    private val textArray = arrayOf("체크리스트", "메모")
    private val arg: HouseDetailFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setViewPagerAdapter()
        setImgViewPagerAdapter()
        start()
    }

    private fun setImgViewPagerAdapter() {
        val adapter = PhotoSliderAdapter()
        binding.apply {
            imgViewpager.adapter = adapter
            imgViewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    val currentPage = position + 1
                    val totalPageSize = this@HouseDetailFragment.viewModel.getImageUriListSize()
                    binding.textImgSize.text = "$currentPage/${totalPageSize}"
                }
            })
        }
    }

    private fun setViewPagerAdapter() {
        val adapter = HouseDetailPagerAdapter(requireActivity())
        binding.apply {
            viewpager.adapter = adapter
            TabLayoutMediator(layoutTab, viewpager) { tab, position ->
                tab.text = textArray[position]
            }.attach()
            viewpager.isSaveEnabled = false
        }
    }

    private fun start() {
        arg.houseId.let {
            viewModel.start(it)
        }
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }
        }
    }

    override fun setEventObservers() {
        viewModel.imageUriList.observe(this, Observer {
            val adapter = binding.imgViewpager.adapter as PhotoSliderAdapter
            adapter.setItem(it)
        })

        viewModel.onClickDeleteBtn.observe(this, EventObserver {
            showDeleteConfirmDialog()
        })

        viewModel.onSuccessDeleteHouse.observe(this, EventObserver {
            showToast("집 정보가 삭제 되었습니다.")
            findNavController().popBackStack()
        })

        viewModel.onClickAddPhotos.observe(this, EventObserver {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                REQUEST_CODE_SELECT_PICTURES
            )
        })
    }

    private fun showDeleteConfirmDialog() {
        AlertDialog.Builder(requireContext())
            .setMessage("정말 삭제하시겠습니까?")
            .setCancelable(true)
            .setNegativeButton("아니요", null)
            .setPositiveButton("네") { _, _ ->
                viewModel.deleteHouse()
            }.create()
            .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_PICTURES && resultCode == Activity.RESULT_OK) {
            val selectedPhotoUris = mutableListOf<Uri>()

            data?.data?.let {
                selectedPhotoUris.add(it)
            }

            data?.clipData?.let { clipData ->
                for (i in 0 until clipData.itemCount) {
                    clipData.getItemAt(i).uri.let { uri ->
                        selectedPhotoUris.add(uri)
                    }
                }
            }
            val uris = selectedPhotoUris.distinctBy { it.toString() }

            viewModel.setImageUriList(uris)
        }
    }
}
