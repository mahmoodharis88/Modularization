package com.blood.donation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.blood.donation.core.navigation.Screens
import com.blood.donation.feature.onboarding.OnBoardingScreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Screens.AppStartNavigation.route,
            startDestination = Screens.OnBoardingScreen.route
        ) {
            composable(route = Screens.OnBoardingScreen.route) {
                OnBoardingScreen()
            }
        }
    }
}
