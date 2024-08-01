package com.sample.mutimodulesample.feature.onboarding


import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sample.mutimodulesample.core.designsystem.component.PagerIndicator
import com.sample.mutimodulesample.core.designsystem.component.SampleButton
import com.sample.mutimodulesample.core.designsystem.component.ThemePreviews
import com.sample.mutimodulesample.core.designsystem.theme.MutiModuleSampleTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(state = pagerState, beyondBoundsPageCount = 1) { index ->
                OnBoardingPage(
                    page = pages[index], pagerState = pagerState, index = index
                )
            }
        }

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PagerIndicator(
                    modifier = Modifier,
                    pagesSize = pages.size,
                    selectedPage = pagerState.currentPage
                )

            }

            val coroutineScope = rememberCoroutineScope()
            SampleButton(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(
                            page = pagerState.currentPage + 1,
                            animationSpec = tween(400)
                        )
                    }
                },
                enabled = true,
                modifier = Modifier
                    .padding(16.dp)
                    .widthIn(364.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary,
                    text = stringResource(
                        if (pagerState.currentPage == 2) R.string.feature_onboarding_done
                        else R.string.feature_onboarding_next
                    ),
                )
            }
        }


    }
}

@ThemePreviews
@Composable
fun OnBoardingScreenPreview() {
    MutiModuleSampleTheme {
        OnBoardingScreen()
    }
}