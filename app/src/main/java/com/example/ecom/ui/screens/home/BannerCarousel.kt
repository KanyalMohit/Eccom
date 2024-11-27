package com.example.ecom.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecom.R
import kotlinx.coroutines.delay
import kotlin.rem

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
    HorizontalPager(
        state = pagerState,
        modifier = modifier.padding(16.dp),

    ) {page->
        Card(
            modifier = Modifier.fillMaxWidth().height(170.dp)
        ) {
            Image(
                painter = painterResource(banner[page].image),
                contentDescription = "banner",
                modifier= Modifier,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}