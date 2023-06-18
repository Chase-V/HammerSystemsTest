package com.example.hammersystemstest.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hammersystemstest.model.BottomBarItem

@Composable
fun BottomNavBarUI(
    bottomNavBarItemsList: List<BottomBarItem>,
    navController: NavController
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        containerColor = Color(0xFFF0F0F0),
    ) {
        bottomNavBarItemsList.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = null
                    )
                },
                label = { Text(text = item.name) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFD3A69),
                    selectedTextColor = Color(0xFFFD3A69),
                    unselectedIconColor = Color(0xFF263238),
                    unselectedTextColor = Color(0xFF263238),
                    indicatorColor = Color(0xFFF0F0F0)
                )
            )
        }
    }
}