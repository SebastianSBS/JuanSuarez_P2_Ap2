package com.example.juansuarez_p2_ap2.presentation.viajes

import com.example.juansuarez_p2_ap2.data.remote.dto.ViajeDto

data class ViajeUiState(
    val idViaje: Int? = null,
    val fecha: String? = null,
    val millas: Int? = 0,
    val tasaDolar: Int? = null,
    val monto: Double = 0.0,
    val observaciones: String = "",
    val errorMessage: String? = "",
    val isLoading: Boolean = false,
    val successMessage: String? = null,
    val viaje: ViajeDto = ViajeDto(),
    val viajes: List<ViajeDto> = emptyList()
)
