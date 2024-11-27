package com.example.ecom.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecom.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeTopAppBar(
    modifier: Modifier = Modifier,
    onCartClick : ()-> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(45.dp),
                    painter = painterResource(R.drawable.online_shopping),
                    contentDescription = "HomeIcon",
                    tint = Color.Unspecified
                )
                Text("Ecom Shop", modifier = Modifier)
            }
        },
        actions = {
            IconButton(onClick = onCartClick) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.shopping_cart),
                    contentDescription = "Cart",
                    tint = Color.Unspecified
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
        )
    )
}