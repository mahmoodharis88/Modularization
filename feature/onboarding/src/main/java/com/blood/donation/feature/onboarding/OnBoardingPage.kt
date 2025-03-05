package com.blood.donation.feature.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.blood.donation.core.designsystem.component.ThemePreviews
import com.blood.donation.core.designsystem.theme.BloodDonationTheme
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page,
    pagerState: PagerState,
    index: Int
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = page.bgImage),
                contentDescription = null
            )
        }

        Column(modifier = Modifier.graphicsLayer {
            // Calculate the absolute offset for the current page from the
            // scroll position. We use the absolute value which allows us to mirror
            // any effects for both directions
            val pageOffset = (
                    (pagerState.currentPage - index) + pagerState
                        .currentPageOffsetFraction
                    ).absoluteValue

            val scale = lerp(1f, 2f, pageOffset)
            scaleX /= scale
            scaleY /= scale
            // We animate the alpha, between 50% and 100%
            alpha = lerp(
                start = 0.5f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f)
            )

        }, horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.fillMaxHeight(0.15f))
            Image(
                modifier = Modifier
                    .padding(horizontal = 64.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.60f),
                painter = painterResource(id = page.image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier.padding(horizontal = 32.dp),
                text = page.title,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(horizontal = 32.dp),
                textAlign = TextAlign.Center,
                text = page.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

        }

    }

}


@OptIn(ExperimentalFoundationApi::class)
@ThemePreviews
@Composable
fun OnBoardingPageOnePreview() {
    BloodDonationTheme {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        OnBoardingPage(page = pages[0], pagerState = pagerState, index = 1)
    }
}


data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
    @DrawableRes val bgImage: Int,
)

val pages = listOf(
    Page(
        title = "Donate  Blood",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.illustration_one,
        bgImage = R.drawable.illustration_one_bg
    ),
    Page(
        title = "Search Blood Donor",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.illustration_two,
        bgImage = R.drawable.illustration_two_bg
    ),
    Page(
        title = "Save Life",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.illustration_three,
        bgImage = R.drawable.illustration_three_bg
    )
)