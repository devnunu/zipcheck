package com.devnunu.zipcheck.ui.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.devnunu.zipcheck.R
import com.devnunu.zipcheck.common.BaseFragmentKoin
import com.devnunu.zipcheck.common.EventObserver
import com.devnunu.zipcheck.databinding.FragmentHomeBinding
import com.devnunu.zipcheck.ui.home.item.HouseItemAdapter
import com.devnunu.zipcheck.ui.home.item.HouseItemListener

class HomeFragment : BaseFragmentKoin<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun setBindingVariables() {
        binding.also {
            it.viewModel = viewModel
            it.listHouse.adapter = HouseItemAdapter(object : HouseItemListener {
                override fun onClickHouseItem(id: Int) {
                    val action = HomeFragmentDirections.actionHomeFragmentToHouseDetailFragment(id)
                    findNavController().navigate(action)
                }
            })
        }
    }

    override fun setEventObservers() {
        viewModel.onClickAddHouseBtn.observe(this, EventObserver {
            val action = HomeFragmentDirections.actionHomeFragmentToInputHouseFragment()
            findNavController().navigate(action)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.menu_clear -> {
//                viewModel.clearCompletedTasks()
                true
            }
            R.id.menu_filter -> {
                showFilteringPopUpMenu()
                true
            }
            R.id.menu_refresh -> {
//                viewModel.loadTasks(true)
                true
            }
            else -> false
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_bar_home, menu)
    }

    private fun showFilteringPopUpMenu() {
        val view = activity?.findViewById<View>(R.id.menu_filter) ?: return
        PopupMenu(requireContext(), view).run {
            menuInflater.inflate(R.menu.action_bar_home, menu)

            setOnMenuItemClickListener {
//                viewModel.setFiltering(
//                    when (it.itemId) {
//                        R.id.active -> TasksFilterType.ACTIVE_TASKS
//                        R.id.completed -> TasksFilterType.COMPLETED_TASKS
//                        else -> TasksFilterType.ALL_TASKS
//                    }
//                )
                true
            }
            show()
        }
    }
}

