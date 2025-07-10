package com.example.juansuarez_p2_ap2.presentation.viajes

sealed interface ViajeEvent {
    data class ViajeChange(val viajeId: Int): ViajeEvent
    data class FechaChange(val fecha: Int): ViajeEvent
    data class MillaChange(val milla: Int): ViajeEvent
    data class ObservacionesChange(val observaciones: String): ViajeEvent
    data class TasaDolarChange(val tasaDolar: Int): ViajeEvent
    data class MontoChange (val monto: Double): ViajeEvent
    data object Save: ViajeEvent
    data object New: ViajeEvent
    data class FindById(val viajeId: Int): ViajeEvent
    data object LoadViajes : ViajeEvent
}
