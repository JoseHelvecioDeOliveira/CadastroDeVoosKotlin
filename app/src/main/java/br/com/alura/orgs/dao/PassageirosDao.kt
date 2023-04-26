package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Passageiro

object PassageirosDao {
    private val passageiros = mutableListOf<Passageiro>()

    fun adiciona(passageiro: Passageiro){
        passageiros.add(passageiro)
    }

    fun buscaTodos() : List<Passageiro> {
        return passageiros.toList()
    }

}