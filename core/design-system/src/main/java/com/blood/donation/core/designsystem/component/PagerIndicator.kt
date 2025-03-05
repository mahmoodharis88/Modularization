package com.blood.donation.core.designsystem.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blood.donation.core.designsystem.theme.BloodDonationTheme

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light theme")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme")
annotation class ThemePreviews

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagesSize: Int,
    selectedPage: Int,
    color: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(times = pagesSize) { page ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .size(height = 7.dp, width = if (page == selectedPage) 15.dp else 7.dp)
                    .clip(CircleShape)
                    .background(color = color)
            )
        }
    }
}

@ThemePreviews
@Composable
fun PagerIndicatorPreview() {
    BloodDonationTheme {
        PagerIndicator(
            pagesSize = 3,
            selectedPage = 1
        )
    }

}
