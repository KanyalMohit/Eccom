package com.example.ecom.ui.screens.productDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.ecom.R


data class ImageCarousel(
    val image : Int
)

/*val imagess = listOf(
    ImageCarousel(R.drawable.iphonee),
    ImageCarousel(R.drawable.iphonee),
    ImageCarousel(R.drawable.iphonee),
    ImageCarousel(R.drawable.iphonee),
    ImageCarousel(R.drawable.iphonee),

    )*/

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageCarousel(modifier: Modifier = Modifier, images: List<String>) {
    val pagerState = rememberPagerState{images.size}
    Box{
        HorizontalPager(
            state = pagerState
        ) {page->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {/*
                Image(
                    painter = painterResource(images[page].image),
                    contentDescription = "banner",
                    modifier= Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(color = Color.Transparent, blendMode = BlendMode.ColorBurn),
                    alignment = Alignment.Center
                )*/
                GlideImage(
                    modifier = Modifier.fillMaxSize(),
                    model = images[page],
                    contentDescription = "image",
                    alignment = Alignment.Center
                )

            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            repeat(images.size) { iteration ->
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(
                            if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                        )
                )
            }
        }

    }
}