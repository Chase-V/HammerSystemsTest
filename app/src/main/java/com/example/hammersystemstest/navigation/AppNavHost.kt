package com.example.hammersystemstest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hammersystemstest.ui.composables.CartScreenUI
import com.example.hammersystemstest.ui.composables.ProfileScreenUI
import com.example.hammersystemstest.ui.composables.menuScreen.MenuScreenUI

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppNavRoute.MenuScreen.route
) {

    NavHost(navController = navController, startDestination = startDestination) {

        composable(AppNavRoute.MenuScreen.route) {
            MenuScreenUI(navController = navController)
        }
        composable(AppNavRoute.ProfileScreen.route) {
            ProfileScreenUI(navController = navController)
        }
        composable(AppNavRoute.CartScreen.route) {
            CartScreenUI(navController = navController)
        }

    }

}