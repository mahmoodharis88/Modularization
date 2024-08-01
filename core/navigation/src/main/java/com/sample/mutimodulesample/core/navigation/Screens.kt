package com.sample.mutimodulesample.core.navigation

import androidx.navigation.NamedNavArgument


sealed class Screens(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object AppStartNavigation : Screens(route = "appStartNavigation")

    data object OnBoardingScreen : Screens(route = "onBoardingScreen")

}
