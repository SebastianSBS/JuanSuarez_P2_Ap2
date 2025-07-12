package com.example.juansuarez_p2_ap2.data.repository

import com.example.juansuarez_p2_ap2.data.remote.ContributorsApi
import com.example.juansuarez_p2_ap2.data.remote.Resource
import com.example.juansuarez_p2_ap2.data.remote.dto.ContributorsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContributorsRepository @javax.inject.Inject constructor(
    private val contributorsApi: ContributorsApi
) {
    fun getContributors(): Flow<Resource<List<ContributorsDto>>> = flow {
        try {
            emit(Resource.Loading())

            val contributors = contributorsApi.getContributors()

            emit(Resource.Success(contributors))

        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.message ?: "Error al conectarse con la API"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error inesperado, verificar tu conexion a internet"))
        }
    }
}