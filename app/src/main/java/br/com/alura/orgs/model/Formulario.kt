package br.com.alura.orgs.model

data class Formulario(
    val origem: String,
    val destino: String,
    val dataIda: String,
    val dataVolta: String,
    val capacidade: Int,
)
