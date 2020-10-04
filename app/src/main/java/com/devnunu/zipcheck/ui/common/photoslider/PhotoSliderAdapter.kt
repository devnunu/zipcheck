package com.devnunu.zipcheck.ui.common.photoslider

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.databinding.ItemCommonPhotoSliderBinding

class PhotoSliderAdapter : RecyclerView.Adapter<PhotoSliderAdapter.PhotoSliderItemViewHolder>() {

    private val uriItemList: MutableList<Uri> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoSliderItemViewHolder {
        val binding = ItemCommonPhotoSliderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PhotoSliderItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PhotoSliderItemViewHolder,
        position: Int
    ) {
        val uri = uriItemList[position]
        holder.bind(uri)
    }

    override fun getItemCount(): Int {
        return uriItemList.size
    }

    fun setItem(itemList: List<Uri>) {
        uriItemList.clear()
        uriItemList.addAll(itemList)
        notifyDataSetChanged()
    }

    inner class PhotoSliderItemViewHolder(private val binding: ItemCommonPhotoSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(uri: Uri) {
            binding.also {
                it.imgHouse.setImageURI(uri)
                it.executePendingBindings()
            }
        }
    }

}