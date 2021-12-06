package com.example.loginwithonboardingjetpack.composables

sealed class Screen(val route: String){
    object OnboardingPage: Screen("onboarding_screen")
    object LoginPage: Screen("login_screen")
}
