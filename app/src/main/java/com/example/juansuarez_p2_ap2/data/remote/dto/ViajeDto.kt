package com.example.juansuarez_p2_ap2.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Viaje")
data class ViajeDto(
    @PrimaryKey
    val idViaje: Int? = 0,
    val fecha: Int = null,
    val millas: Int? = null,
    val tasaDolar: Int? = null,
    val observaciones: String = "",
    val monto: Double = 0.0
)

