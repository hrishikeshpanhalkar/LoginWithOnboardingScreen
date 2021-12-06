package com.example.loginwithonboardingjetpack.composables

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.OnboardingPage.route){
        composable(route = Screen.OnboardingPage.route){
            OnboardingPage(navController = navController)
        }
        composable(
            route = Screen.LoginPage.route,
        ){
            LoginPage()
        }
    }
}