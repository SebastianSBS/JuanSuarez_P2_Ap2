package com.example.juansuarez_p2_ap2.presentation.viajes

import com.example.juansuarez_p2_ap2.data.remote.dto.ViajeDto

sealed interface ViajeEvent {
    data class ViajeChange(val viajeId: Int): ViajeEvent
    data class FechaChange(val fecha: String): ViajeEvent
    data class MillaChange(val milla: Int): ViajeEvent
    data class ConceptoChange(val concepto: String): ViajeEvent
    data class TasaDolarChange(val tasaDolar: Int): ViajeEvent
    data object Save: ViajeEvent
    data class Delete(val viaje: ViajeDto): ViajeEvent
    data object New: ViajeEvent
    data class FindById(val viajeId: Int): ViajeEvent
    data object LoadViajes : ViajeEvent
}
