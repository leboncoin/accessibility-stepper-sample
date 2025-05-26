package com.example.accessibilitysteppersample.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.accessibilitysteppersample.MenuItem

private const val MENU_DESTINATION = "Menu"

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MENU_DESTINATION,
    ) {
        composable(route = MENU_DESTINATION) {
            MenuScreen(
                onMenuItemClick = { menuItem ->
                    navController.navigate(route = menuItem.navDestination)
                },
            )
        }
        MenuItem.entries.forEach { menuItem ->
            composable(route = menuItem.navDestination) {
                ComponentScreen(
                    menuItem = menuItem,
                    onBackClick = { navController.popBackStack() },
                )
            }
        }
    }
}