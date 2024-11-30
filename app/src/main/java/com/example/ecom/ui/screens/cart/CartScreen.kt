package com.example.ecom.ui.screens.cart

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ecom.ui.screens.home.BottomNavigationBar

@Composable
fun CartScreen(modifier: Modifier = Modifier , navController: NavHostController) {
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding->

    }
}