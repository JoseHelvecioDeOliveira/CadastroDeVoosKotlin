package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.application.BaseApplication
import br.com.alura.orgs.model.Passageiro

class FormularioPassageiroActivity :
    AppCompatActivity(R.layout.activity_formulario_passageiro) {
    lateinit var myApp: BaseApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myApp = application as BaseApplication
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.button_salvar_passageiro)
        botaoSalvar.setOnClickListener {
            val passageiroNovo = criaPassageiro()
            myApp.passageiroDao.adiciona(passageiroNovo)
            vaiParaFormularioVooActivity()
        }
    }
    private fun vaiParaFormularioVooActivity() {
        val intent = Intent(this, FormularioVooActivity::class.java)
        startActivity(intent)
    }

    private fun criaPassageiro(): Passageiro {
        val campoNome = findViewById<EditText>(R.id.activity_tela_tripulante_nome)
        val nome = campoNome.text.toString()

        val campoIdade = findViewById<EditText>(R.id.activity_tela_tripulante_tempo_experiencia)
        val idade = campoIdade.text.toString().toInt()

        return Passageiro(
            nome = nome,
            idade = idade
        )
    }
}