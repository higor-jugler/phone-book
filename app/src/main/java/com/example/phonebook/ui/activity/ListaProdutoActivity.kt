package com.example.phonebook.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.R
import com.example.phonebook.dao.ProdutoDao
import com.example.phonebook.recyclerview.adapter.ListaProdutoAdapter

class ListaProdutoActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutoDao()
    private val adapter = ListaProdutoAdapter(this, dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun configFab() {
        val fab: View = findViewById(R.id.activity_lista_botao_add)
        fab.setOnClickListener { it ->
            configFormularioProduto()
        }
    }

    private fun configFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produto_recyclerview)
        recyclerView.adapter = adapter
    }
}