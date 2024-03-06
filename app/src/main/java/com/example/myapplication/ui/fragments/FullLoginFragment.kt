package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentFullLoginBinding

class FullLoginFragment : BaseFragment<FragmentFullLoginBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_full_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnToSignIn.setOnClickListener {
                navigateToSignIn()
            }
            btnToSignUp.setOnClickListener {
                navigateToSignUp()
            }
        }
    }

    private fun navigateToSignIn() {
        navigationCallBack?.navigateToSignIn(
            addBackStack = true,
            inclusive = false,
            nameFragmentBackStack = FULL_LOGIN
        )
    }

    private fun navigateToSignUp() {
        navigationCallBack?.navigateToSignUp(
            addBackStack = true,
            inclusive = false,
            nameFragmentBackStack = FULL_LOGIN
        )
    }

    companion object {
        const val FULL_LOGIN = "FULL_LOGIN"
    }
}