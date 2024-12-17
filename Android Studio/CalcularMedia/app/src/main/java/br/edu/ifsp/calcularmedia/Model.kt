package br.edu.ifsp.calcularmedia

// Modelo que representa os valores e pesos para cálculo das médias
data class MediaData(
    val valores: List<Double>,
    val pesos: List<Double>? = null // Pesos são opcionais, usados apenas na média ponderada
)
