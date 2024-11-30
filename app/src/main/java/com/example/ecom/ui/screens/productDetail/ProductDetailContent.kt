package com.example.ecom.ui.screens.productDetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecom.model.product.Product

@Composable
fun ProductDetailsContent(product: Product) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        ImageCarousel(modifier = Modifier, images = product.imageUrls)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                ProductBrandAndRating(
                    brand = product.brand,
                    rating = product.rating,
                    ratingCount = product.ratingCount,
                    onFavouriteClick = {

                    }
                )
                Spacer(modifier = Modifier.height(0.dp))
                Text(product.name, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                ProductPrice(
                    price = product.price,
                    orignalPrice = product.originalPrice
                )
                Spacer(modifier = Modifier.height(8.dp))
                ProductDescription(
                    description = product.description
                )
            }
        }
    }
}

@Composable
fun ProductDescription(description: String) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Column {
        Text("Product Description", fontWeight = FontWeight.SemiBold , fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            description,
            fontSize = 16.sp,
            maxLines = if(expanded) Int.MAX_VALUE else 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.clickable{
                expanded = !expanded
            }
        )
        if(!expanded){
            Text("Read More", fontSize = 14.sp, color = Color.Blue, modifier = Modifier.clickable{
                expanded = !expanded}
            )
        }
    }
}



