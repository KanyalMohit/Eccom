package com.example.ecom.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

sealed class BottomNavItem(var title : String, var icon : ImageVector, var route : String) {
    object Home :  BottomNavItem("Home", Icons.Outlined.Home, "home")
    object Wishlist : BottomNavItem("Wishlist", Icons.Outlined.FavoriteBorder, "wishlist")
    object Cart :  BottomNavItem("Cart", Icons.Outlined.ShoppingCart, "cart")
    object Account :  BottomNavItem("Account", Icons.Outlined.Person, "account")
    object Explore : BottomNavItem("Explore", Icons.Outlined.Search,"explore")
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    return navBackStackEntry.value?.destination?.route
}

