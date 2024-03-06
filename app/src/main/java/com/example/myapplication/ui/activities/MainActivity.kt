package com.example.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myapplication.R
import com.example.myapplication.core.navigation.NavigationCallBack
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.fragments.BottomSheetFragment
import com.example.myapplication.ui.fragments.FullLoginFragment
import com.example.myapplication.ui.fragments.MainFragment
import com.example.myapplication.ui.fragments.SignInFragment
import com.example.myapplication.ui.fragments.SignUpFragment
import com.example.myapplication.ui.fragments.TabsFragment

class MainActivity : AppCompatActivity(), NavigationCallBack {

   lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        if (savedInstanceState == null) supportFragmentManager.commit {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            replace(R.id.contMain, FullLoginFragment())
        }
        with(binding) {
            tvBottomNavigationView.setOnClickListener {
                drawerLayout.closeDrawers()
                supportFragmentManager.commit {
                    replace<MainFragment>(R.id.contMain)
                }
            }
            tvTabs.setOnClickListener {
                drawerLayout.closeDrawers()
                supportFragmentManager.commit {
                    replace<TabsFragment>(R.id.contMain)
                }
            }
            tvBottomSheet.setOnClickListener {
                drawerLayout.closeDrawers()
                supportFragmentManager.commit {
                    replace<BottomSheetFragment>(R.id.contMain)
                }
            }
        }
    }

    override fun navigateToSignIn(
        addBackStack: Boolean,
        inclusive: Boolean,
        nameFragmentBackStack: String
    ) {
        supportFragmentManager.commit {
            replace(R.id.contMain,SignInFragment())
            if (inclusive) supportFragmentManager.popBackStack(
                null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
            if (addBackStack) addToBackStack(nameFragmentBackStack)
        }
    }

    override fun navigateToSignUp(
        addBackStack: Boolean,
        inclusive: Boolean,
        nameFragmentBackStack: String
    ) {
        supportFragmentManager.commit {
            replace(R.id.contMain, SignUpFragment())
            if (inclusive) supportFragmentManager.popBackStack(
                null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
            if (addBackStack) addToBackStack(nameFragmentBackStack)
        }
    }

    override fun navigateToMain(
        addBackStack: Boolean,
        inclusive: Boolean,
        nameFragmentBackStack: String
    ) {
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        supportFragmentManager.commit {
            replace(R.id.contMain, MainFragment())
            if (inclusive) supportFragmentManager.popBackStack(
                null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
            if (addBackStack) addToBackStack(nameFragmentBackStack)
        }
    }
}