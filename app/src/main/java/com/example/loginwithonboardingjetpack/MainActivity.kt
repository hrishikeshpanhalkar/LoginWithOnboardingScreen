package com.example.loginwithonboardingjetpack

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.loginwithonboardingjetpack.composables.Navigation
import com.example.loginwithonboardingjetpack.composables.OnboardingPage
import com.example.loginwithonboardingjetpack.ui.theme.LoginWithOnboardingJetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.WHITE
        setContent {
            LoginWithOnboardingJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                ) {
                    Navigation()
                }
            }
        }
    }
}