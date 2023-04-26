package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Tripulante

object TripulanteDao {
    private val tripulantes = mutableListOf<Tripulante>()

    fun adiciona(tripulante: Tripulante) {
        tripulantes.add(tripulante)
    }

    fun buscaTodos(): List<Tripulante> {
        return tripulantes.toList()
    }
}