package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentTabsBinding
import com.example.myapplication.ui.adapters.TabsAdapter
import com.google.android.material.tabs.TabLayoutMediator

class TabsFragment : BaseFragment<FragmentTabsBinding>() {

    private var adapter: TabsAdapter? = null

    override val layoutId: Int
        get() = R.layout.fragment_tabs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            adapter = TabsAdapter(this@TabsFragment)
            pager.adapter = adapter
            pager.let {
                TabLayoutMediator(tabLayout, it) { tab, position ->
                    tab.text = "TAB ${(position)}"
                }.attach()
            }
        }
    }
}