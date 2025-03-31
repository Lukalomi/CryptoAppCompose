package com.example.cryptocompose.presentation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboard.presentation.HomeScreen
import com.example.favourites.presentation.FavouritesScreen
import com.example.news.presentation.NewsScreen
import com.example.settings.presentation.SettingsScreen


@Composable
fun BottomNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItems.Home.route
    ) {
        composable(route = BottomBarItems.Home.route) {
            HomeScreen()
        }

        composable(route = BottomBarItems.News.route) {
            NewsScreen()
        }

        composable(route = BottomBarItems.Favourites.route) {
            FavouritesScreen()
        }

        composable(route = BottomBarItems.Settings.route) {
            SettingsScreen()
        }

    }
}