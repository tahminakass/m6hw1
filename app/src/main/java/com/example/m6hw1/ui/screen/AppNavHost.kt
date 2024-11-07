package com.example.m6hw1.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost


import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.m6hw1.ui.Screen

@Composable
fun AppNavHost(navController: NavController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(onNavigateToRegistration = {
                navController.navigate(Screen.Registration.route)
            })
        }
        composable(Screen.Registration.route) {
            RegistrationScreen(onNavigateConfirmation = { userName ->
                navController.navigate(Screen.Confirmation.createRoute(userName))
            })
        }
        composable(
            route = Screen.Confirmation.route,
            arguments = listOf(navArgument("userName") { type = NavType.StringType })
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            ConfirmationScreen(
                userName = userName,
                onNavigateToProfile = { navController.navigate(Screen.Profile.route) }
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
    }
}