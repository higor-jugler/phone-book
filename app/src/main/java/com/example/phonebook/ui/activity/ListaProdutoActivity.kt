package com.example.phonebook.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.phonebook.R

class ListaProdutoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)
        configFab()
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

}