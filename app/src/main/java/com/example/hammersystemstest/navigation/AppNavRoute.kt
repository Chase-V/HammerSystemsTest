package com.example.hammersystemstest.navigation

sealed class AppNavRoute(val route: String) {
    object MenuScreen : AppNavRoute(route = "menu")
    object ProfileScreen : AppNavRoute(route = "profile")
    object CartScreen : AppNavRoute(route = "cart")
}