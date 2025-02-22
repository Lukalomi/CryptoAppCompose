package com.example.cryptocompose.presentation.bottomnavigation

import androidx.annotation.StringRes
import com.example.cryptocompose.R

sealed class BottomBarItems(
    val route: String,
    @StringRes val title: Int,
    val icon: Int
) {

    data object Home : BottomBarItems(
        route = "Home",
        title = R.string.home,
        icon = R.drawable.ic_home
    )

    data object News : BottomBarItems(
        route = "Information",
        title = R.string.news,
        icon = R.drawable.ic_news
    )

    data object Favourites : BottomBarItems(
        route = "QR Scan",
        title = R.string.favourites,
        icon = R.drawable.ic_favourites
    )

    data object Videos : BottomBarItems(
        route = "Services",
        title = R.string.videos,
        icon = R.drawable.ic_videos //TODO remake it to settings Later
    )
}