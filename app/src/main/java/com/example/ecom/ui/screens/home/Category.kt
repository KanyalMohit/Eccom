package com.example.ecom.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecom.R

data class Category(
    val name : String,
    val icon : Int,
    val route : String
)

val categories = listOf(
    Category("Winter",R.drawable.coat,"Winter"),
    Category("Summer",R.drawable.tshirt,"Summer"),
    Category("Pants",R.drawable.pants,"pant"),
    Category("Shoes",R.drawable.shoes,"shoes"),
    Category("Watch",R.drawable.accesories,"watch"),
    Category("Furniture",R.drawable.furniture,"Furniture"),
    Category("Electronics",R.drawable.electronics,"electronics"),
    Category("Games",R.drawable.game,"games")
)


@Composable
fun CategoryGrid(navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.padding(16.dp).height(157.dp),
        userScrollEnabled = false
    ) {
        items(categories) { category ->
            OutlinedCard(
                onClick = {
                    navController.navigate("category"+"/${category.route}")
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.padding(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp).fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(category.icon),
                        contentDescription = category.name,
                        tint = Color.Unspecified
                    )
                    Text(category.name, softWrap = false, overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}


