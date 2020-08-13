package com.devnunu.zipcheck.ui.inputtemplateitem

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragment
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.common.util.StyleUtil
import com.devnunu.zipcheck.databinding.FragmentInputTemplateItemBinding
import com.devnunu.zipcheck.ui.inputtemplateitem.item.InputTemplateItemAdapter
import com.devnunu.zipcheck.ui.inputtemplateitem.item.OnStartActionListener


class InputTemplateItemFragment :
    BaseFragment<FragmentInputTemplateItemBinding, InputTemplateItemViewModel>(
        R.layout.fragment_input_template_item,
        InputTemplateItemViewModel::class
    ), OnStartActionListener {

    private val itemTouchHelper by lazy {
        ItemTouchHelper(getItemTouchHelperCallback())
    }

    private val arg: InputTemplateItemFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setArgument(arg.checklistName)
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.onClickBackBtn = View.OnClickListener { findNavController().popBackStack() }

            // recycler view
            it.listItem.adapter = InputTemplateItemAdapter(this, viewModel)
            it.listItem.addItemDecoration(StyleUtil.getDividerItemDecoration(R.drawable.divider_mono200))
            it.listItem.itemAnimator = DefaultItemAnimator()

            // add touch helper for swipe and move
            itemTouchHelper.attachToRecyclerView(it.listItem)
        }
    }

    override fun setEventObservers() {
        viewModel.onSuccessSaveTemplate.observe(this, EventObserver {
            val action =
                InputTemplateItemFragmentDirections.actionCheckListTemplateFragmentToInputCheckListFragment()
            findNavController().navigate(action)
        })

        viewModel.onClickAddItem.observe(this, EventObserver { checkItem ->
            val adapter = binding.listItem.adapter as InputTemplateItemAdapter
            adapter.addItem(checkItem)
        })
    }

    /** item touch and swipe listener */
    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder?) {
        viewHolder?.let {
            itemTouchHelper.startDrag(it)
        }
    }

    override fun onStartSwipe(viewHolder: RecyclerView.ViewHolder?) {
        viewHolder?.let {
            itemTouchHelper.startSwipe(it)
        }
    }

    private fun getItemTouchHelperCallback(): ItemTouchHelper.SimpleCallback {
        return object :
            ItemTouchHelper.SimpleCallback(
                DOWN or UP,
                START
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                if (viewHolder.itemViewType != target.itemViewType) return false
                val adapter = recyclerView.adapter as InputTemplateItemAdapter
                adapter.moveItem(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                super.onSelectedChanged(viewHolder, actionState)
                if (actionState == ACTION_STATE_DRAG) {
                    viewHolder?.itemView?.alpha = 0.5f
                }
            }

            override fun clearView(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ) {
                super.clearView(recyclerView, viewHolder)
                viewHolder.itemView.alpha = 1.0f
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition
                val adapter = binding.listItem.adapter as InputTemplateItemAdapter
                adapter.removeItem(position)
            }

            override fun getSwipeEscapeVelocity(defaultValue: Float): Float {
                return defaultValue * 10
            }
        }
    }
}