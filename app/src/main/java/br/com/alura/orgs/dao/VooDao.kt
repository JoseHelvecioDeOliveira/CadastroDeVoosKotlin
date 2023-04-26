package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Voo

object VooDao {
    private val voos = mutableListOf<Voo>()

    fun adiciona(voo: Voo) {
        voos.add(voo)
    }

    fun buscaTodos(): List<Voo> {
        return voos.toList()
    }
}