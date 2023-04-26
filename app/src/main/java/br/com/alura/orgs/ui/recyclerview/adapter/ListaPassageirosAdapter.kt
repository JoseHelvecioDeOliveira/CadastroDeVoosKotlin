package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Passageiro

class ListaPassageirosAdapter(
    private val context: Context,
    passageiros: List<Passageiro>
) : RecyclerView.Adapter<ListaPassageirosAdapter.ViewHolder>() {

    private val passageiros = passageiros.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(passageiro: Passageiro) {
            val nome = itemView.findViewById<TextView>(R.id.text_view_nome_passageiro)
            nome.text = passageiro.nome
            val idade = itemView.findViewById<TextView>(R.id.text_view_idade_passageiro)
            idade.text = passageiro.idade.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.voo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val passageiro = passageiros[position]
        holder.vincula(passageiro)
    }

    override fun getItemCount(): Int = passageiros.size

    fun atualiza(passageiros: List<Passageiro>) {
        this.passageiros.clear()
        this.passageiros.addAll(passageiros)
        notifyDataSetChanged()
    }

}
