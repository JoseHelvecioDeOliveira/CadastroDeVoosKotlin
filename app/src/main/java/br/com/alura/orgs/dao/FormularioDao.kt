package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Voo

object FormularioDao {
    private var formulario = Voo(
        origem = "",
        destino = "",
        dataIda = "",
        dataVolta = "",
        textoAeroportos = "",
        textoAutorizado = "",
        autorizado = false,
        capacidade = 0,
        passageiros = emptyList(),
        tripulacao = emptyList()
    )

    fun adiciona(formulario: Voo) {
        this.formulario = formulario
    }

    fun buscaFormulario(): Voo {
        return formulario
    }
}