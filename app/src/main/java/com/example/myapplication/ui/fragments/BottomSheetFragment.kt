package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.get
import androidx.core.view.isVisible
import com.example.myapplication.R
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentBottomSheetBinding
import com.example.myapplication.ui.extensions.gone
import com.example.myapplication.ui.extensions.invisible
import com.example.myapplication.ui.extensions.visible
import com.google.android.material.bottomsheet.BottomSheetBehavior


class BottomSheetFragment : BaseFragment<FragmentBottomSheetBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_bottom_sheet

    private var bottomSheetBehavior: BottomSheetBehavior<View>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            setupBottomSheet()
            if (savedInstanceState == null) {
                bottomSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
            }
            btnBottomSheet.setOnClickListener {
                bottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            requireActivity().onBackPressedDispatcher.addCallback(
                this@BottomSheetFragment.viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        if (bottomSheetBehavior?.state != BottomSheetBehavior.STATE_HIDDEN) {
                            bottomSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
                        } else {
                            remove()
                            requireActivity().onBackPressedDispatcher.onBackPressed()
                        }
                    }
                })
        }
    }

    private fun setupBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetContentContainer)
        bottomSheetBehavior?.isHideable = true
    }

}