package com.example.ecom.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ecom.Navigation.Screen
import com.example.ecom.ui.screens.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeScreenViewModel: SharedViewModel
) {
    var products = homeScreenViewModel.product.collectAsState()
    var searchText = remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier,
        topBar = {
            HomeTopAppBar(
                modifier = Modifier,
                onCartClick = {
                    navController.navigate(Screen.Cart.route)
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {innerPadding->
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            if(products.value.isEmpty()){
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            else{
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                ) {
                    item{
                        ProductSearchBar(searchText)
                    }
                    item{
                        CategoryGrid(navController)
                    }
                    item{
                        BannerCarousel(modifier = Modifier)
                    }
                    item{
                        Text(
                            text = "Popular Products",
                            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    item{
                        ItemGrid(
                            navController = navController,
                            products = products.value.subList(0,16)
                        )
                    }
                }
            }

        }

    }
}






