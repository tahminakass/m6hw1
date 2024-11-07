package com.example.m6hw1.ui

sealed class Screen(val route: String) {
    object Welcome: Screen("welcome to screen")
    object Registration: Screen("registration_screen")
    object Confirmation: Screen("confirmation_screen/{userName}") {
        fun createRoute(userName: String) = "confirmation_screen/$userName"
    }
    object Profile: Screen("profile_screen")
}