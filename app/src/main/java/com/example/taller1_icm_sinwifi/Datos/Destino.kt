package com.example.taller1_icm_sinwifi.Datos

import java.io.Serializable

data class Destino(
    val id: Int,
    val nombre: String,
    val pais: String,
    val categoria: String,
    val plan: String,
    val precio: Double
) : Serializable