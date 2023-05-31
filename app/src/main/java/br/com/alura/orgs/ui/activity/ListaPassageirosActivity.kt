package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.application.BaseApplication
import br.com.alura.orgs.dao.PassageirosDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaPassageirosAdapter

class ListaPassageirosActivity :
    AppCompatActivity(R.layout.activity_lista_passageiros) {

    lateinit var myApp: BaseApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myApp = application as BaseApplication

    }


    private val dao = PassageirosDao
    private val adapter = ListaPassageirosAdapter(context = this, passageiros = dao.buscaTodos())

    /*  override fun onCreate(savedInstanceState: Bundle?) {
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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_adicao, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.create_new) {
            vaiParaFormularioPassageirosActivity()
        }
        return super.onOptionsItemSelected(item)
    }*/
}
