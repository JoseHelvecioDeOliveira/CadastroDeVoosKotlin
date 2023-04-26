package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.PassageirosDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaPassageirosAdapter

class ListaPassageirosActivity :
    AppCompatActivity(R.layout.activity_lista_passageiros) {


    private val dao = PassageirosDao
    private val adapter = ListaPassageirosAdapter(context = this, passageiros = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.app_name)
        configuraRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(PassageirosDao.buscaTodos())
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_lista_passageiros)
        recyclerView.adapter = adapter
    }
}
