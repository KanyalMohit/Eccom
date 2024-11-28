package com.example.ecom.ui.screens.productDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecom.R


data class ImageCarousel(
    val image : Int
)

val imagess = listOf(
    ImageCarousel(R.drawable.iphonee),
    ImageCarousel(R.drawable.iphonee),
    ImageCarousel(R.drawable.iphonee),
    )

@Composable
fun ImageCarousel(modifier: Modifier = Modifier, images: List<ImageCarousel>) {
    val pagerState = rememberPagerState{images.size}
    Box {
        HorizontalPager(
            state = pagerState
        ) {page->
            Card(
                modifier = Modifier.fillMaxWidth().height(400.dp)
            ) {
                Image(
                    painter = painterResource(images[page].image),
                    contentDescription = "banner",
                    modifier= Modifier,
                    contentScale = ContentScale.FillWidth,
                    colorFilter = ColorFilter.tint(color = Color.Transparent, blendMode = BlendMode.ColorBurn)
                )
            }
        }
    }
}