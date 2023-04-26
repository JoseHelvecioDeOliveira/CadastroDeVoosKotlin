package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.PassageirosDao
import br.com.alura.orgs.dao.VooDao
import br.com.alura.orgs.model.Passageiro
import br.com.alura.orgs.model.Voo
import java.math.BigDecimal

class FormularioVooActivity :
    AppCompatActivity(R.layout.activity_formulario_voo) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_passageiro_botao_salvar)
        botaoSalvar.setOnClickListener {
            val vooNovo = criaVoo()
            VooDao.adiciona(vooNovo)
            finish()
        }
    }

    private fun criaVoo(): Voo {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_passageiro_nome)
        val nome = campoNome.text.toString()

        val campoOrigem = findViewById<EditText>(R.id.activity_formulario_passageiro_origem)
        val origem = campoOrigem.text.toString()

        val campoDestino = findViewById<EditText>(R.id.activity_formulario_passageiro_destino)
        val destino = campoDestino.text.toString()

        val campoDataIda = findViewById<EditText>(R.id.activity_formulario_passageiro_dataIda)
        val dataIda = campoDataIda.text.toString()

        val campoDataVolta = findViewById<EditText>(R.id.activity_formulario_passageiro_dataVolta)
        val dataVolta = campoDataVolta.text.toString()

        val campoCapacidade = findViewById<EditText>(R.id.activity_formulario_passageiro_capacidade)
        val capacidade = campoCapacidade.text.toString().toInt()

        return Voo(
            origem = origem,
            destino = destino,
            dataIda= dataIda,
            dataVolta= dataVolta,
            capacidade = capacidade,
            passageiros = listOf(),
            tripulacao = listOf(),
            autorizado = true
        )
    }

}