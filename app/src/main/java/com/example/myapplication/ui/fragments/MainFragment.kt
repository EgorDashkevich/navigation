package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myapplication.R
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_home -> {
                        navigateToBNM0()
                        true
                    }

                    R.id.navigation_dashboard -> {
                        navigateToBNM1()
                        true
                    }

                    R.id.navigation_notifications -> {
                        navigateToBNM2()
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }
    }

    private fun navigateToBNM0() {
        childFragmentManager.commit {
            replace<BNM0Fragment>(R.id.contMainFragment)
        }
    }

    private fun navigateToBNM1() {
        childFragmentManager.commit {
            replace<BNM1Fragment>(R.id.contMainFragment)
        }
    }

    private fun navigateToBNM2() {
        childFragmentManager.commit {
            replace<BNM2Fragment>(R.id.contMainFragment)
        }
    }

}