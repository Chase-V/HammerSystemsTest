package com.example.hammersystemstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.hammersystemstest.model.BottomBarItem
import com.example.hammersystemstest.navigation.AppNavHost
import com.example.hammersystemstest.navigation.AppNavRoute
import com.example.hammersystemstest.ui.composables.BottomNavBarUI
import com.example.hammersystemstest.ui.theme.HammerSystemsTestTheme
import com.example.hammersystemstest.viewModel.ServerResponseViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val exampleBottomBarItemList = listOf<BottomBarItem>(
            BottomBarItem(
                name = getString(R.string.menu),
                route = AppNavRoute.MenuScreen.route,
                iconId = R.drawable.menu_icon
            ),
            BottomBarItem(
                name = getString(R.string.profile),
                route = AppNavRoute.ProfileScreen.route,
                iconId = R.drawable.profile_icon
            ),
            BottomBarItem(
                name = getString(R.string.cart),
                route = AppNavRoute.CartScreen.route,
                iconId = R.drawable.cart_icon
            )
        )

        setContent {

            val navController = rememberNavController()

            HammerSystemsTestTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavBarUI(
                            bottomNavBarItemsList = exampleBottomBarItemList,
                            navController = navController
                        )
                    }
                ) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        AppNavHost(navController = navController)
                    }
                }
            }
        }
    }
}
