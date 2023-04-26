package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaVoosActivity : AppCompatActivity(R.layout.activity_lista_voos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraFab()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_adicao, menu)
        return true
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.fab_create_voo)
        fab.setOnClickListener {
            vaiParaFormularioPassageiro()
        }
    }

    private fun vaiParaFormularioPassageiro() {
        val intent = Intent(this, FormularioVooActivity::class.java)
        startActivity(intent)
    }

    private fun irTelaCriacaoPassageiros() {
        val intent = Intent(this, FormularioVooActivity::class.java)
        startActivity(intent)
    }
}