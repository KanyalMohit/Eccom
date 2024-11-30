package com.example.ecom.ui.screens.productDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductBrandAndRating(brand: String, rating: Double, ratingCount: Int , onFavouriteClick : () -> Unit) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Text(brand, color = Color.DarkGray, fontSize = 20.sp)
        Icon(
            modifier = Modifier.size(20.dp),
            imageVector = Icons.Default.Star,
            contentDescription = "Stars",
            tint = Color(0xFFFFA000)
        )
        Text("${rating} (${ratingCount})", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {

            }
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "Stars",
            )
        }
    }
}