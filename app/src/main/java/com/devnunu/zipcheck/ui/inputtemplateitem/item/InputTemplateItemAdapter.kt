package com.devnunu.zipcheck.ui.inputtemplateitem.item

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.template.model.CheckItem
import com.devnunu.zipcheck.databinding.ItemInputTemplateBinding
import java.util.*

class InputTemplateItemAdapter(
    private val onStartActionListener: OnStartActionListener,
    private val dataChangeListener: InputTemplateItemListener
) :
    RecyclerView.Adapter<InputTemplateItemAdapter.CategoryViewHolder>() {

    private val checkItems: MutableList<CheckItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemInputTemplateBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        val holder = CategoryViewHolder(binding)

        // set item action listener
        binding.imgHandle.setOnTouchListener { _, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                onStartActionListener.onStartDrag(holder)
            }
            false
        }
        binding.textName.setOnTouchListener { _, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                onStartActionListener.onStartSwipe(holder)
            }
            false
        }

        return holder
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
        val item = checkItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return checkItems.size
    }

    fun addItem(checkItem: CheckItem) {
        checkItems.add(0, checkItem)
        dataChangeListener.onChangeCheckItems(checkItems)
        notifyItemInserted(0)
    }

    fun removeItem(position: Int) {
        checkItems.removeAt(position)
        dataChangeListener.onChangeCheckItems(checkItems)
        notifyItemRemoved(position)
    }

    fun moveItem(originPos: Int, targetPos: Int) {
        Collections.swap(checkItems, originPos, targetPos)
        dataChangeListener.onChangeCheckItems(checkItems)
        notifyItemMoved(originPos, targetPos)
    }

    inner class CategoryViewHolder(val binding: ItemInputTemplateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CheckItem?) {
            binding.also {
                it.item = item
                it.executePendingBindings()
            }
        }
    }
}