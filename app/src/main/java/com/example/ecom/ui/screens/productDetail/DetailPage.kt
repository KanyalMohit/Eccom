package com.example.ecom.ui.screens.productDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecom.ui.screens.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    productId: Int?,
    sharedViewModel: SharedViewModel,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {
    val products = sharedViewModel.product.collectAsState()
    val product = productDetailViewModel.getProductById(productId!!,products.value)
    Scaffold(
        topBar = {
            DetailTopAppBar(navController = navController)
        },
        bottomBar = {
            DetailBottomAppBar()
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFFFFF)
        ) {
            if(product == null){
                Box(contentAlignment = Alignment.Center,){
                    Text("${product}")
                }
            }else{
                Box(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    ProductDetailsContent(
                        product = product
                    )
                }
            }
        }
    }
}


