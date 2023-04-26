package br.com.alura.orgs.model

data class Voo(
    val origem: String,
    val destino: String,
    val dataIda: String,
    val dataVolta: String,
    val autorizado: Boolean,
    val capacidade: Int,
    val passageiros: List<Passageiro>,
    val tripulacao: List<Tripulante>

)
