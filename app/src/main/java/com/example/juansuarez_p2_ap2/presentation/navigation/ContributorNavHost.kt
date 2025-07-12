package com.example.juansuarez_p2_ap2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.juansuarez_p2_ap2.presentation.viajes.ContributorsListScreen

@Composable
fun ContributorNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ContributorsList
    ) {
        composable  <Screen.ContributorsList> {
            ContributorsListScreen ()
        }
    }
}
