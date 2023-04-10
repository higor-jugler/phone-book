package com.example.phonebook.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.phonebook.R
import com.example.phonebook.dao.ProdutoDao
import com.example.phonebook.model.Produto

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_botao)
        val dao = ProdutoDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_nome)
        val nome = campoNome.text.toString()
        val compoDescricao = findViewById<EditText>(R.id.activity_formulario_descricao)
        val descricao = compoDescricao.text.toString()
        val campoNumero = findViewById<EditText>(R.id.activity_formulario_numero)
        val numeroEmTexto = campoNumero.text.toString()
        val numero = numeroEmTexto.toInt()

        return Produto(
            nome = nome,
            descricao = descricao,
            numero = numero
        )
    }
}