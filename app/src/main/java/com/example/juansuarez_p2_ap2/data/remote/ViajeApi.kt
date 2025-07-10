package com.example.juansuarez_p2_ap2.data.remote

import com.example.juansuarez_p2_ap2.data.remote.dto.ViajeDto
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ViajeApi {
    @GET("api/Viajes")
    @Headers("X-API-Key: test")
    suspend fun getViajes(): List<ViajeDto>

    @PUT("api/Viajes/{id}")
    @Headers("X-API-Key: test")
    suspend fun getViajesById(@Path("id") id: Int): ViajeDto

    @POST("api/Viajes")
    @Headers("X-API-Key: test")
    suspend fun postViajes(@Body viajes: ViajeDto): ViajeDto
}
