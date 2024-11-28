package com.example.ecom.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecom.Navigation.BottomNavItem
import com.example.ecom.Navigation.currentRoute

@Composable
fun BottomNavigationBar(
    navController : NavHostController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Explore,
        BottomNavItem.Wishlist,
        BottomNavItem.Profile
    )
    NavigationBar(
        modifier = Modifier
            .graphicsLayer {
                clip = true
                shape = RectangleShape
            }
            .fillMaxWidth().height(60.dp),
        containerColor = Color(0x9AFFB300)
    ) {
        items.forEach { item ->
            NavigationBarItem(
                modifier = Modifier.offset(y=3.dp),
                selected = currentRoute(navController) == item.route,
                onClick = {
                    /*navController.navigate(item.route) {
                        // Pop up to the root destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true*/
                },
                icon = {
                    Icon(
                        modifier = Modifier,
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodySmall,
                    )
                },
                alwaysShowLabel = true,
            )
        }
    }
}