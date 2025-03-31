package com.example.cryptocompose.presentation.bottomnavigation

import androidx.annotation.StringRes
import com.example.cryptocompose.R

sealed class BottomBarItems(
    val route: String,
    @StringRes val title: Int,
    val icon: Int
) {

    data object Home : BottomBarItems(
        route = HOME_ROUTE,
        title = R.string.home,
        icon = R.drawable.ic_home
    )

    data object News : BottomBarItems(
        route = NEWS_ROUTE,
        title = R.string.news,
        icon = R.drawable.ic_news
    )

    data object Favourites : BottomBarItems(
        route = FAVOURITES_ROUTE,
        title = R.string.favourites,
        icon = R.drawable.ic_favourites
    )

    data object Settings : BottomBarItems(
        route = SETTINGS_ROUTE,
        title = R.string.settings,
        icon = R.drawable.ic_videos //TODO remake it to settings Later
    )


    companion object {
        private const val HOME_ROUTE = "home"
        private const val NEWS_ROUTE = "news"
        private const val FAVOURITES_ROUTE = "favourites"
        private const val SETTINGS_ROUTE = "settings"
    }


}