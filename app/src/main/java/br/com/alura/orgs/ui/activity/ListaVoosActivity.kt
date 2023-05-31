package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.application.BaseApplication
import br.com.alura.orgs.ui.recyclerview.adapter.ListaVoosAdapter

class ListaVoosActivity : AppCompatActivity(R.layout.activity_lista_voos) {
    lateinit var myApp: BaseApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myApp = application as BaseApplication
        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_voos_recycler_view)
        recyclerView.adapter = ListaVoosAdapter(this, myApp.vooDao.buscaTodos())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        setUpRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_adicao, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         if (item.itemId == R.id.create_new) {
             vaiParaFormularioVooActivity()
         }
         return super.onOptionsItemSelected(item)
     }

     private fun vaiParaFormularioVooActivity() {
         val intent = Intent(this, FormularioVooActivity::class.java)
         startActivity(intent)

         /*val alertDialog: AlertDialog = this.let {
             val builder = AlertDialog.Builder(it)
             builder.apply {
                 setPositiveButton(R.string.dialog_ok_text,
                     DialogInterface.OnClickListener { dialog, id ->

                     })
                 setNegativeButton(R.string.dialog_cancel_text,
                     DialogInterface.OnClickListener { dialog, id ->
                         // User cancelled the dialog
                     })
                 setTitle(R.string.dialog_title_text)
             }
             builder.create()
         }
     }*/
     }
}