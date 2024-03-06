package com.example.myapplication.core.navigation

interface NavigationCallBack {

    fun navigateToSignIn(addBackStack: Boolean, inclusive: Boolean, nameFragmentBackStack: String)
    fun navigateToSignUp(addBackStack: Boolean, inclusive: Boolean, nameFragmentBackStack: String)
    fun navigateToMain(addBackStack: Boolean, inclusive: Boolean, nameFragmentBackStack: String)

}