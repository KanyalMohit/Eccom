package com.example.ecom.ui.screens.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.ecom.ui.screens.SharedViewModel
import com.example.ecom.ui.screens.home.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    cartViewModel: CartViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    cartViewModel.fetchCart()

    val products = sharedViewModel.product.collectAsState()
    cartViewModel.getProductsInCart(products.value)
    val cartItems = cartViewModel.cartItems.collectAsState().value

        Scaffold(
            modifier = Modifier,
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("My Cart", fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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
            },
            containerColor = Color.White
        ) { innerPadding ->
            if(cartItems.isEmpty()){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }else{
                Box(modifier = Modifier.padding(innerPadding)) {
                    LazyColumn {
                        items(cartItems) { cart ->
                            OutlinedCard(
                                onClick = {},
                                modifier = Modifier.padding(12.dp),
                                colors = CardDefaults.outlinedCardColors(
                                    containerColor = Color.White
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(16.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.height(100.dp)
                                    ) {
                                        GlideImage(
                                            model = cart.thumbnail,
                                            contentDescription = "Product Image"
                                        )
                                    }
                                    Box(
                                        modifier = Modifier.padding(16.dp)
                                    ) {
                                        Column {
                                            Text(
                                                cart.name,
                                                maxLines = 1,
                                                fontWeight = FontWeight.SemiBold,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            cart.sizes?.isEmpty()?.let {
                                                Text(
                                                    if(!it)"Size : ${cart.sizes.get(0)}" else "Not available"
                                                )
                                            }
                                            Spacer(Modifier.height(20.dp))
                                            Text(
                                                "$${cart.price}"
                                            )
                                        }
                                    }
                                }
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.BottomEnd,
                                ) {
                                    Row {
                                        Button(onClick = {

                                        },
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent
                                            )) {
                                            Text("-")
                                        }
                                        Text("${cartViewModel.getCartItemCount()}")
                                        Button(onClick = {

                                        }) {
                                            Text("+")
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }

        }
    }


