package com.example.ud4_ejercicio.modelo

data class RestauranteUIState(
    val pedidos: MutableList<Pedido> = mutableListOf()
)
