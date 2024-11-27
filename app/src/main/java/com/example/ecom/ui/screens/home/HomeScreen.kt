package com.example.ecom.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecom.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    var searchText = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            HomeTopAppBar(
                modifier = Modifier,
                onCartClick = {
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {innerPadding->
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
            ) {
                ProductSearchBar(searchText)
                CategoryGrid(navController)
                BannerCarousel(modifier = Modifier)

            }

        }

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = NavHostController(LocalContext.current))
}