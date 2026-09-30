package com.example.librerias

import org.jetbrains.compose.resources.DrawableResource


data class Auto(
    val imagen: DrawableResource,
    val marca: String,
    val modelo: String,
    val anio: Int,
    val precio: Long,
)
