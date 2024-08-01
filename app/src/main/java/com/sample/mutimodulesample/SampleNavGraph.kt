package com.sample.mutimodulesample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.sample.mutimodulesample.core.navigation.Screens
import com.sample.mutimodulesample.feature.onboarding.OnBoardingScreen

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
