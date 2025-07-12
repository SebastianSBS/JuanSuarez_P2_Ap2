package com.example.juansuarez_p2_ap2.presentation.viajes

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object ContributorsList: Screen()
}

