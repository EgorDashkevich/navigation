package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentTabBinding

class TabFragment : BaseFragment<FragmentTabBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_tab

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
                tvNameTab.text = getString(R.string.tabs_blank_fragment,getInt(ARG_OBJECT).toString())
            }
        }
    }

    companion object {
        const val ARG_OBJECT = "object"
    }
}