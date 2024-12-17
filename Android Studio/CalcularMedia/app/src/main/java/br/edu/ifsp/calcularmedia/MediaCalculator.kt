package br.edu.ifsp.calcularmedia

// Classe responsável pelo cálculo das médias
object MediaCalculator {

    fun calcularMediaAritmetica(data: MediaData): Double {
        return if (data.valores.isNotEmpty()) {
            data.valores.sum() / data.valores.size
        } else 0.0
    }

    fun calcularMediaPonderada(data: MediaData): Double {
        val valores = data.valores
        val pesos = data.pesos
        return if (!valores.isNullOrEmpty() && !pesos.isNullOrEmpty() && valores.size == pesos.size) {
            var somaPesos = 0.0
            var somaPonderada = 0.0
            for (i in valores.indices) {
                somaPonderada += valores[i] * pesos[i]
                somaPesos += pesos[i]
            }
            somaPonderada / somaPesos
        } else 0.0
    }

    fun calcularMediaHarmonica(data: MediaData): Double {
        return if (data.valores.isNotEmpty()) {
            val inversoSoma = data.valores.sumOf { 1.0 / it }
            data.valores.size / inversoSoma
        } else 0.0
    }
}
