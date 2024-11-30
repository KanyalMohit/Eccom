package com.example.ecom.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecom.R

data class Banner(
    val image : Int
)

val banner = listOf(
    Banner(R.drawable.banner),
    Banner(R.drawable.banner2),
    Banner(R.drawable.banner3),
    Banner(R.drawable.banner4),
)


@Composable
fun BannerCarousel(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState{
        banner.size
    }
    Column(

    ) {
        Box {
            HorizontalPager(
                state = pagerState,
                modifier = modifier.padding(16.dp),

                ) { page ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                ) {
                    Image(
                        painter = painterResource(banner[page].image),
                        contentDescription = "banner",
                        modifier = Modifier,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
        Box(
            modifier= Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(banner.size) { iteration ->
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(
                                if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                            )
                    )
                    Spacer(Modifier.width(8.dp))
                }
            }
        }
    }
}