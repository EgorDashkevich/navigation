package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentSignUpBinding

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_sign_up


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnSignIn.setOnClickListener { navigateToSignIn() }
        }
    }

    private fun navigateToSignIn() {
        navigationCallBack?.navigateToSignIn(
            addBackStack = false,
            inclusive = false,
            nameFragmentBackStack = SIGN_UP
        )
    }

    companion object {
        const val SIGN_UP = "SIGN_UP"
    }
}
