package com.example.ecom.ui.screens.productDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductDetailsContent() {
    Column {
        ImageCarousel(modifier = Modifier, images = imagess)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                ProductBrandAndRating()
                Spacer(modifier = Modifier.height(0.dp))
                Text("Iphone 16", fontWeight = FontWeight.SemiBold, fontSize = 26.sp)
                Spacer(modifier = Modifier.height(8.dp))
                ProductPrice()
                Spacer(modifier = Modifier.height(8.dp))
                ProductDescription()
            }
        }
    }
}

@Composable
fun ProductDescription() {
    Column {
        Text("Product Description", fontWeight = FontWeight.SemiBold , fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "The iPhone 16 is Apple's flagship smartphone for 2024, featuring a stunning display, powerful processor, and advanced camera system. Its sleek design and intuitive interface make it a top choice for tech enthusiasts.",
            fontSize = 16.sp
        )
    }
}



