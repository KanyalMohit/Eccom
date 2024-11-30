package com.example.ecom.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.ecom.Navigation.Screen
import com.example.ecom.R
import com.example.ecom.model.product.Product
import kotlin.math.log

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemGrid(modifier: Modifier = Modifier , navController: NavController, products : List<Product>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.height(( 30.times(85).dp)),
        contentPadding = PaddingValues(16.dp),
        userScrollEnabled = false
    ) {
        items(products) { product->
            OutlinedCard(
                onClick = {
                    Log.d("ItemGrid", "productId: ${product.stock}")
                    navController.navigate("${Screen.DetailPage.route}/${product.stock}")
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        GlideImage(
                            model = product.thumbnail,
                            contentDescription = product.name,
                            contentScale = ContentScale.Fit
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(3.dp)
                            ){
                                Text(product.brand, color = Color.Gray, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                Icon(
                                    modifier = Modifier.size(12.dp),
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Stars",
                                    tint = Color(0xFFFFA000)
                                )
                                Text("${product.rating}", maxLines = 1)
                            }
                            Text(product.name, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text("₹${product.price}", color = Color(0xFFE64A19))
                                Text(
                                    "₹${product.originalPrice}",
                                    textDecoration = TextDecoration.LineThrough,
                                    color = Color.LightGray
                                )
                            }
                        }

                    }
                }
            }

        }
    }

}

