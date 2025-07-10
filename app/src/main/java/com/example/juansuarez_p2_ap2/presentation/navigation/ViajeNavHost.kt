package com.example.juansuarez_p2_ap2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun ViajeNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ViajeList
    ) {
        composable <Screen.ViajeList> {
            ViajeListScreen(
                goToViaje = {
                    navHostController.navigate(Screen.Viaje(it))
                },
                createViaje = {
                    navHostController.navigate(Screen.Viaje(0))
                }
            )
        }

        composable<Screen.Viaje> {
            val args = it.toRoute()<Screen.Viaje>()
            ViajeScreen (
                DepositoId = args.depositoId,
                goBack = {
                    navHostController.navigateUp()
                }
            )
        }
    }
}
