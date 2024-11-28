package com.example.ecom.ui.screens.home

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.unit.dp
import com.example.ecom.R

@Composable
fun ItemGrid(modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.height(( 10.times(70).dp)),
        contentPadding = PaddingValues(16.dp),
        userScrollEnabled = true
    ) {
        item {
            OutlinedCard(
                onClick = {
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
                            .height(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.iphonee),
                            contentDescription = "iPhone",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
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
                                Text("Apple", color = Color.Gray)
                                Icon(
                                    modifier = Modifier.size(12.dp),
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Stars",
                                    tint = Color(0xFFFFA000)
                                )
                                Text("4.9 (300)")
                            }
                            Text("Iphone 16", fontWeight = FontWeight.Bold)
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text("$1000", color = Color(0xFFE64A19))
                                Text(
                                    "$1599",
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