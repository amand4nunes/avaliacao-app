package com.example.vamos_lucrar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.text.set
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.time.seconds

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var valorTotalRegistrado = 0.0
    fun cadastrarProduto(v: View) {
        val row = TableRow(this)
        val nome = TextView(this)
        val codigo = TextView(this)
        val quantidade = TextView(this)
        val valor = TextView(this)
        var confirmaCad = 0


        //nome
        if (nomeProduto.text.toString().length == 0) {
            Toast.makeText(
                this,
                "O nome do pruduto está vazio nele deve ter entre 2 a 10 caracteres",
                Toast.LENGTH_LONG
            ).show()
        } else if (nomeProduto.text.toString().length < 2 || nomeProduto.text.toString().length > 10) {
            Toast.makeText(this, " deve ter entre 2 a 10 caracteres", Toast.LENGTH_LONG).show()
        } else {
            nome.text = nomeProduto.text
            row.addView(nome)
            confirmaCad += 1
        }
        //codigo
        if (codigoProduto.text.toString().length == 0) {
            Toast.makeText(
                this,
                "O código do pruduto está vazio nele deve ter entre 4 digitos",
                Toast.LENGTH_LONG
            ).show()
        } else if (codigoProduto.text.toString().length > 4) {
            Toast.makeText(this, " deve ter apenas 4 digitos", Toast.LENGTH_LONG).show()
        } else {
            codigo.text = codigoProduto.text
            row.addView(codigo)
            confirmaCad += 1
        }

        //quantidade
        if (quantidadeProduto.text.toString().length == 0) {
            Toast.makeText(this, "A quantidade do pruduto está vazio", Toast.LENGTH_LONG).show()
        } else if (quantidadeProduto.text.toString()
                .toInt() <= 0 || quantidadeProduto.text.toString().toInt() > 5
        ) {
            Toast.makeText(this, " A quantidade deve ser entre 1 até 5 ", Toast.LENGTH_LONG).show()
        } else {
            quantidade.text = quantidadeProduto.text
            row.addView(quantidade)
            confirmaCad += 1
        }
        //valor
        if (precoProduto.text.toString().length == 0) {
            Toast.makeText(this, "O valor do produto está vazio", Toast.LENGTH_LONG).show()
        } else if (precoProduto.text.toString().toDouble() == 0.0) {
            Toast.makeText(this, "O valor do produto não pode ser zero", Toast.LENGTH_LONG).show()
        } else {
            valor.text = precoProduto.text
            val multiplica =
                precoProduto.text.toString().toDouble() * quantidadeProduto.text.toString().toInt()
            valorTotalRegistrado += multiplica
            row.addView(valor)
            confirmaCad += 1
        }
        if (confirmaCad == 4) {
            registro.addView(row)
            registro.visibility = View.VISIBLE
            resultado.visibility = View.VISIBLE
            textValorTotalRegistrado.text = "R$ ${valorTotalRegistrado.toString()}"
        }


    }

    fun finalizarCadastro(v: View) {
        val recebe = pagamento.text
        val trocoPag = recebe.toString().toDouble() - valorTotalRegistrado.toString().toDouble()
        troco.text = trocoPag.toString()
        if (trocoPag >= 0.0) {
            troco.setTextColor(Color.parseColor("#00FF00"))

        } else {
            troco.setTextColor(Color.parseColor("#FF0000"))
        }

    }

}

