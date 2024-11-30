package com.example.ecom.ui.screens.productDetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductPrice(price: Int, orignalPrice: Int) {
    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("₹${price}", color = Color(0xFF000000), fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
            SuggestionChip(
                modifier = Modifier
                    .width(85.dp)
                    .height(20.dp),
                onClick = {

                },
                label = { Text("35% off", color = Color.Red, fontWeight = FontWeight.SemiBold) },
                shape = RoundedCornerShape(10.dp),
                colors = SuggestionChipDefaults.suggestionChipColors(
                    disabledLabelColor = Color(0xF0441414),
                    containerColor = Color(0xFFFBE7E9),
                ),
                border = BorderStroke(0.dp,Color.Transparent)
            )
        }
        Text(
            "₹${orignalPrice}",
            textDecoration = TextDecoration.LineThrough,
            color = Color.Gray,
            fontSize = 18.sp
        )
    }
}