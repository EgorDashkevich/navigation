package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.myapplication.R
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentSignInBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_sign_in

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnSignIn.setOnClickListener {
                navigateToMain()
            }
        }
    }

    private fun navigateToMain() {
        navigationCallBack?.navigateToMain(
            addBackStack = false,
            inclusive = true,
            nameFragmentBackStack = SIGN_IN
        )
    }

    companion object {
        const val SIGN_IN = "SIGN_IN"
    }

}