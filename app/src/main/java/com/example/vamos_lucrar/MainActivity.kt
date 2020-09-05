package com.example.vamos_lucrar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun cadastrarProduto(v: View) {
        registro.visibility = View.VISIBLE

        val row = TableRow(this)
        val nome = TextView(this)
        val codigo = TextView(this)
        val quantidade = TextView(this)
        val valor = TextView(this)
        row.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        nome.text = nomeProduto.text
        row.addView(nome)
        codigo.text = codigoProduto.text
        row.addView(codigo)
        quantidade.text = quantidadeProduto.text
        row.addView(quantidade)
        valor.text = precoProduto.text
        row.addView(valor)
        if (validacao()){
        registro.addView(row)
    }else{
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_LONG).show()
        }
    }

    fun validacao(): Boolean {
        return (nomeProduto.text.toString() != "" &&
                codigoProduto.text.toString() != "" &&
                quantidadeProduto.text.toString() != "" &&
                precoProduto.text.toString() != "")
    }


    fun finalizarCadastro(v: View) {

    }
}
