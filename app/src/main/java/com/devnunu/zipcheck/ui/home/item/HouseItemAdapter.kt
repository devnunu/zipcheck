package com.devnunu.zipcheck.ui.home.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.house.model.House
import com.devnunu.zipcheck.databinding.ItemHomeHouseBinding

class HouseItemAdapter(val listener: HouseItemListener) :
    RecyclerView.Adapter<HouseItemAdapter.HomeViewHolder>() {

    private val houseItemList: MutableList<HouseItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewHolder {
        val binding = ItemHomeHouseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomeViewHolder,
        position: Int
    ) {
        val viewModel = houseItemList[position]
        holder.bind(viewModel)
    }

    override fun getItemCount(): Int {
        return houseItemList.size
    }

    private fun setItem(houseList: List<House>) {
        houseItemList.clear()
        houseItemList.addAll(getHouseItem(houseList))
        notifyDataSetChanged()
    }

    private fun getHouseItem(
        houseList: List<House>
    ): List<HouseItem> {
        return houseList.map {
            HouseItem(it)
        }
    }

    inner class HomeViewHolder(private val binding: ItemHomeHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HouseItem?) {
            binding.also {
                it.item = item
                it.listener = listener
                it.executePendingBindings()
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["items"])
        fun bindItem(
            recyclerView: RecyclerView,
            items: List<House>?
        ) {
            val adapter = recyclerView.adapter as HouseItemAdapter?
            items?.let {
                adapter?.setItem(it)
            }
        }
    }
}