package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.application.BaseApplication
import br.com.alura.orgs.model.Tripulante

class FormularioTripulanteActivity :
    AppCompatActivity(R.layout.activity_formulario_tripulante) {
    lateinit var myApp: BaseApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myApp = application as BaseApplication
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.button_salvar_tripulante)
        botaoSalvar.setOnClickListener {
            val tripulanteNovo = criaTripulante()
            myApp.tripulanteDao.adiciona(tripulanteNovo)
            vaiParaFormularioVooActivity()
        }
    }

    private fun vaiParaFormularioVooActivity() {
        val intent = Intent(this, FormularioVooActivity::class.java)
        startActivity(intent)
    }

    private fun criaTripulante(): Tripulante {
        val campoNome = findViewById<EditText>(R.id.activity_tela_tripulante_nome)
        val nome = campoNome.text.toString()

        val campoTempoExperiencia =
            findViewById<EditText>(R.id.activity_tela_tripulante_tempo_experiencia)
        val experiencia = campoTempoExperiencia.text.toString().toInt()

        val campoCargo = findViewById<EditText>(R.id.activity_tela_tripulante_cargo)
        val cargo = campoCargo.text.toString()

        return Tripulante(
            nome = nome,
            tempoExperiencia = experiencia,
            cargo = cargo
        )
    }


}