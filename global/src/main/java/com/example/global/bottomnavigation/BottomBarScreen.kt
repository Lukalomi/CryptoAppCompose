package com.example.global.bottomnavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBarScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(
                navController = navController,
            )
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarItems.Home,
        BottomBarItems.News,
        BottomBarItems.Favourites,
        BottomBarItems.Settings
    )
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination

    screens.forEach { screen ->
        if (currentDestination?.route == screen.route) {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }

            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarItems,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    NavigationBarItem(
        label = { Text(text = stringResource(id = screen.title), fontSize = 10.sp) },
        icon = { Icon(painter = painterResource(id = screen.icon), null) },
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
