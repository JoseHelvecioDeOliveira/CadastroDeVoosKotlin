package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Voo

class ListaVoosAdapter(
    private val context: Context,
    voos: List<Voo>,
) : RecyclerView.Adapter<ListaVoosAdapter.ListaVoosViewHolder>() {

    private val voos = voos.toMutableList()

    class ListaVoosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun vincula(voo: Voo) {
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
            vooQuantidadeTripulante.text = voo.tripulacao.size.toString()
            val vooQuantidadePassageiro =
                itemView.findViewById<TextView>(R.id.text_view_numero_passageiros)
            vooQuantidadePassageiro.text = voo.passageiros.size.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaVoosViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.voo_item, parent, false)
        return ListaVoosViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaVoosViewHolder, position: Int) {
        val voo = voos[position]
        holder.vincula(voo)
        val imageViewDelete = holder.itemView.findViewById<ImageView>(R.id.image_view_delete)
        imageViewDelete.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = voos.size

    fun atualiza(voo: List<Voo>) {
        this.voos.clear()
        this.voos.addAll(voo)
        notifyDataSetChanged()
    }

}

