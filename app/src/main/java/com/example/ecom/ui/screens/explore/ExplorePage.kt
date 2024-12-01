package com.example.ecom.ui.screens.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecom.model.product.Product
import com.example.ecom.ui.screens.SharedViewModel
import com.example.ecom.ui.screens.home.BottomNavigationBar
import com.example.ecom.ui.screens.home.CategoryGrid
import com.example.ecom.ui.screens.home.ItemGrid

@Composable
fun ExplorePage(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val products = sharedViewModel.product.collectAsState()
    ExplorePageContent(navController,products.value)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplorePageContent(navController: NavHostController, products: List<Product>) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Explore", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = {

                }) {
                    Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
        )
    },
        bottomBar = {
            BottomNavigationBar(navController)
        }) { innerPadding ->
            Surface(
                modifier = Modifier.padding(innerPadding).verticalScroll(rememberScrollState()),
                color = Color.White,
            ) {
                Column(
                    modifier = Modifier
                ) {
                    CategoryGrid(navController)
                    ItemGrid(navController = navController, products = products , userScrollEnabled = true)
                }
            }
    }
}