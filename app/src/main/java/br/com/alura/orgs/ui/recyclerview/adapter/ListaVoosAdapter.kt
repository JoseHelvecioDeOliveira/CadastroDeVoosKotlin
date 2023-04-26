package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R

class ListaVoosAdapter(
    private val context: Context,
    voos: List<VooViewEntity>
) : RecyclerView.Adapter<ListaVoosAdapter.ViewHolder>() {

    private val voos = voos.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(voo: VooViewEntity) {
            val aeroportos = itemView.findViewById<TextView>(R.id.text_view_aeroportos)
            aeroportos.text = voo.textoAeroportos
            val dataIda = itemView.findViewById<TextView>(R.id.text_view_data_origem)
            dataIda.text = voo.dataIda
            val dataVolta = itemView.findViewById<TextView>(R.id.text_view_data_destino)
            dataVolta.text = voo.dataVolta
            val vooAutorizado = itemView.findViewById<TextView>(R.id.text_view_autorizado)
            vooAutorizado.text = voo.textoAutorizado
            val vooQuantidadeTripulante =
                itemView.findViewById<TextView>(R.id.text_view_numero_tripulantes)
            vooQuantidadeTripulante.text = voo.quantidadeTripulantes
            val vooQuantidadePassageiro =
                itemView.findViewById<TextView>(R.id.text_view_numero_passageiros)
            vooQuantidadePassageiro.text = voo.quantidadePassageiros
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.voo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val voo = voos[position]
        holder.vincula(voo)
    }

    override fun getItemCount(): Int = voos.size

    fun atualiza(voo: List<VooViewEntity>) {
        this.voos.clear()
        this.voos.addAll(voo)
        notifyDataSetChanged()
    }

}

