package com.example.phonebook.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.R
import com.example.phonebook.model.Produto

class ListaProdutoAdapter(
    private val context: Context,
    produto: List<Produto>

) : RecyclerView.Adapter<ListaProdutoAdapter.ViewHolder>() {

    private val produto = produto.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.lista_contato)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.lista_descricao)
            descricao.text = produto.descricao
            val numero = itemView.findViewById<TextView>(R.id.lista_numero)
            numero.text = produto.numero.toString()
        }
    }

    /*
    Cria uma nova instância do ViewHolder quando necessário. Este método é responsável por inflar o
    layout XML da View e criar uma nova instância do ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.lista_produto, parent, false)
        return ViewHolder(view)
    }

    /*
    Atualiza o conteúdo do ViewHolder com os dados de um determinado item da lista. Este método é
    responsável por atualizar as Views do ViewHolder com os dados apropriados.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produto[position]
        holder.vincula(produto)
    }

    /*
    Retorna o número total de itens na lista.
     */
    override fun getItemCount(): Int = produto.size
}
