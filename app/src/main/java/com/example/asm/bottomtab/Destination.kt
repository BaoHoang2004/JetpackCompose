package com.example.asm.bottomtab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {
    object Home : Destinations(
        route = "Home",
        title = "Home",
        icon = Icons.Outlined.Home
    )

    object Favourite : Destinations(
        route = "Favourite",
        title = "Favorite",
        icon = Icons.Outlined.Favorite
    )

    object Notification : Destinations(
        route = "Notification",
        title = "Notification",
        icon = Icons.Outlined.Notifications
    )
    object Person : Destinations(
        route = "Person",
        title = "Person",
        icon = Icons.Outlined.Person
    )

}