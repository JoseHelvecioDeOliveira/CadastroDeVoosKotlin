package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.application.BaseApplication
import br.com.alura.orgs.model.Voo

class FormularioVooActivity :
    AppCompatActivity(R.layout.activity_formulario_voo) {

    lateinit var myApp: BaseApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myApp = application as BaseApplication
        configuraBotaoSalvar()
        configuraBotaoAdicionarTripulante()
        configuraBotaoAdicionarPassageiro()
    }

    override fun onResume() {
        super.onResume()
        val textViewTripulante = findViewById<TextView>(R.id.text_view_quantidade_tripulantes)
        val textViewPassageiro = findViewById<TextView>(R.id.text_view_quantidade_passageiro)
        val textQuantidadeTripulante =
            "Tripulante: " + myApp.tripulanteDao.buscaTodos().size.toString()
        val textQuantidadePassageiro =
            "Passageiro: " + myApp.passageiroDao.buscaTodos().size.toString()
        textViewTripulante.text = textQuantidadeTripulante
        textViewPassageiro.text = textQuantidadePassageiro
       configuraFormulario()

    }

    fun configuraFormulario() {
        val formularioObj = myApp.formularioDao.buscaFormulario()

        val campoOrigem = findViewById<EditText>(R.id.activity_formulario_passageiro_origem)
        campoOrigem.setText(formularioObj.origem)

        val campoDestino = findViewById<EditText>(R.id.activity_formulario_passageiro_destino)
        campoDestino.setText(formularioObj.destino)

        val campoDataIda = findViewById<EditText>(R.id.activity_formulario_passageiro_dataIda)
        campoDataIda.setText(formularioObj.dataIda)

        val campoDataVolta = findViewById<EditText>(R.id.activity_formulario_passageiro_dataVolta)
        campoDataVolta.setText(formularioObj.dataVolta)

        val campoCapacidade = findViewById<EditText>(R.id.activity_formulario_passageiro_capacidade)
        campoCapacidade.setText(formularioObj.capacidade.toString())
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_voo_botao_salvar)
        botaoSalvar.setOnClickListener {
            criaVoo()
            val vooNovo = myApp.formularioDao.buscaFormulario()
            myApp.vooDao.adiciona(vooNovo)
            vaiParaListaVoosActivity()
        }
    }

    private fun configuraBotaoAdicionarTripulante() {
        val botaoAdicionarTripulante =
            findViewById<Button>(R.id.activity_formulario_tripulante_adicionar)
        botaoAdicionarTripulante.setOnClickListener {
            criaVoo()
            vaiParaFormularioTripulanteActivity()
        }
    }

    private fun configuraBotaoAdicionarPassageiro() {
        val botaoAdicionarPassageiro =
            findViewById<Button>(R.id.activity_formulario_passageiro_adicionar)
        botaoAdicionarPassageiro.setOnClickListener {
            criaVoo()
            vaiParaFormularioPassageirosActivity()
        }
    }

    private fun vaiParaFormularioTripulanteActivity() {
        val intent = Intent(this, FormularioTripulanteActivity::class.java)
        startActivity(intent)
    }

    private fun vaiParaFormularioPassageirosActivity() {
        val intent = Intent(this, FormularioPassageiroActivity::class.java)
        startActivity(intent)
    }

    private fun vaiParaListaVoosActivity() {
        val intent = Intent(this, ListaVoosActivity::class.java)
        startActivity(intent)
    }

    private fun criaVoo() {

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

        val textoAeroportos = "$origem-$destino"

        val autorizado = true
        val textoAutorizado = if (autorizado) {
            "Voo autorizado"
        } else "Voo não autorizado"

        val voo = Voo(
            origem = origem,
            destino = destino,
            dataIda = dataIda,
            dataVolta = dataVolta,
            capacidade = capacidade,
            passageiros = myApp.passageiroDao.buscaTodos(),
            tripulacao = myApp.tripulanteDao.buscaTodos(),
            autorizado = autorizado,
            textoAeroportos = textoAeroportos,
            textoAutorizado = textoAutorizado
        )
        myApp.formularioDao.adiciona(voo)
    }

}