package com.example.juansuarez_p2_ap2.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.juansuarez_p2_ap2.data.remote.Resource
import com.example.juansuarez_p2_ap2.data.remote.ViajeApi
import com.example.juansuarez_p2_ap2.data.remote.dto.ViajeDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ViajeRepository @Inject constructor(
    private val viajeApi:ViajeApi
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getViajes(): Flow<Resource<List<ViajeDto>>> = flow {
        try {
            emit(Resource.Loading())

            val viajes = viajeApi.getViajes()

            emit(Resource.Success(viajes))

        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error al conectarse con la API"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error inesperado, verificar tu conexion a internet"))
        }
    }

    fun getViajesById(viajeId: Int): Flow<Resource<ViajeDto>> = flow {
        try {
            emit(Resource.Loading())

            val viajes = viajeApi.getViajesById(viajeId)

            emit(Resource.Success(viajes))

        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.message ?: "Error al conectarse con la API"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error inesperado, verificar tu conexion a internet"))
        }
    }

    fun postViajes(viajeDto: ViajeDto): Flow<Resource<ViajeDto>> = flow{
        try {
            emit(Resource.Loading())

            viajeApi.postViajes(viajeDto)
            emit(Resource.Success(viajeDto))

        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.message ?: "Error al conectarse con la API"))
        }
        catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error inesperado, verificar tu conexion a internet"))
        }
    }
}
