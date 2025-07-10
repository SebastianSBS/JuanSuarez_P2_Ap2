package com.example.juansuarez_p2_ap2.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object ViajeList: Screen()

    @Serializable
    data class Viaje(val viajeId: Int?) : Screen()
}
