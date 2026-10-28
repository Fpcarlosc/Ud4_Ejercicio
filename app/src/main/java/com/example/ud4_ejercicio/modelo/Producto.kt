package com.example.ud4_ejercicio.modelo

import androidx.annotation.DrawableRes

open class Producto(
    @DrawableRes val imagen: Int,
    val nombre: String = "",
    precio: Double
)
