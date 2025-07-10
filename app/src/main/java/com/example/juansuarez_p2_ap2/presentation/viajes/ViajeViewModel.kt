package com.example.juansuarez_p2_ap2.presentation.viajes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.juansuarez_p2_ap2.data.remote.Resource
import com.example.juansuarez_p2_ap2.data.remote.dto.ViajeDto
import com.example.juansuarez_p2_ap2.data.repository.ViajeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViajeViewModel @Inject constructor(
    private val viajeRepository: ViajeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ViajeUiState())
    val state = _state.asStateFlow()

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getViajes() {
        viewModelScope.launch {
            try {
                viajeRepository.getViajes().collect { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.update { it.copy(isLoading = true, errorMessage = null) }
                        }

                        is Resource.Success -> {
                            _state.update {
                                it.copy(
                                    viajes = result.data ?: emptyList(),
                                    isLoading = false,
                                    errorMessage = null
                                )
                            }
                        }

                        is Resource.Error -> {
                            _state.update {
                                it.copy(
                                    errorMessage = result.message ?: "Error desconocido",
                                    isLoading = false
                                )
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        errorMessage = "Error inesperado: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }

    fun postViajes() {
        viewModelScope.launch {
            try {
                viajeRepository.postViajes(state.value.viaje).collectLatest { result ->
                    when(result){
                        is Resource.Loading -> {
                            _state.update { it.copy(isLoading = true) }
                        }

                        is Resource.Success -> {
                            _state.update {
                                it.copy(
                                    successMessage = "Guardado correctamente",
                                    isLoading = false
                                )
                            }
                        }

                        is Resource.Error -> {
                            _state.update {
                                it.copy(
                                    errorMessage = result.message ?: "Ocurrio un error, intentelo de nuevo",
                                    isLoading = false
                                )
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        errorMessage = "Error de conexión: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }

    fun getViajeById(viajeId: Int) {
        viewModelScope.launch {
            viajeRepository.getViajesById(viajeId).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.update { it.copy(isLoading = true) }
                    }

                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                viaje = result.data ?: ViajeDto(),
                                isLoading = false
                            )
                        }
                    }

                    is Resource.Error -> {
                        _state.update {
                            it.copy(
                                errorMessage = "Ocurrio un error, intentelo de nuevo",
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @RequiresApi(Build.VERSION_CODES.O)
    fun onEvent(event: ViajeEvent) {
        when (event) {
            is ViajeEvent.ViajeChange -> {
                _state.update {
                    it.copy(
                        viaje = it.viaje.copy(idViaje = event.viajeId)
                    )
                }
            }

            is ViajeEvent.FechaChange -> {
                _state.update {
                    it.copy(
                        viaje = it.viaje.copy(fecha = event.fecha)
                    )
                }
            }

            is ViajeEvent.MillaChange -> {
                _state.update {
                    it.copy(
                        viaje = it.viaje.copy(millas = event.milla)
                    )
                }
            }

            is ViajeEvent.TasaDolarChange -> {
                _state.update {
                    it.copy(
                        viaje = it.viaje.copy(tasaDolar = event.tasaDolar)
                    )
                }
            }

            is ViajeEvent.MontoChange -> {
                _state.update {
                    it.copy(
                        viaje = it.viaje.copy(monto = event.monto)
                    )
                }
            }

            is ViajeEvent.ObservacionesChange -> {
                _state.update {
                    it.copy(
                        viaje = it.viaje.copy(observaciones = event.observaciones)
                    )
                }
            }

            ViajeEvent.Save -> {
                    postViajes()
            }

            ViajeEvent.New -> {
                _state.update {
                    it.copy(
                        successMessage = null,
                        errorMessage = "",
                        isLoading = false
                    )
                }
            }

            is ViajeEvent.FindById -> {
                getViajeById(event.viajeId)
            }

            ViajeEvent.LoadViajes -> {
                getViajes()
            }
        }
    }
}
