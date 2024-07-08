package com.example.p1_taynacugler

import Cliente
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import banco.DAO

class TerceiraTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val cliente: Cliente? = intent.getParcelableExtra("cliente")
        val dao = DAO(this)
        if (cliente != null) {
            dao.mostrarUmCliente(cliente.cpf)
        }


        if (cliente != null) {
            Toast.makeText(this, "Cliente: ${cliente.nome}, CPF: ${cliente.cpf}, Telefone: ${cliente.telefone}, Email: ${cliente.email}", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Cliente não encontrado", Toast.LENGTH_LONG).show()
        }
        val botaoSair: Button = findViewById(R.id.bt_sair)
        botaoSair.setOnClickListener {
            finish()
        }
        val botaoPedidos: Button = findViewById(R.id.pedidos_bt)
        botaoPedidos.setOnClickListener {
            val intentPedidos = Intent(this, QuintaTela::class.java)
            intentPedidos.putExtra("cliente", cliente)
            startActivity(intentPedidos)
        }
        val botaoConta: Button = findViewById(R.id.conta_bt)
        botaoConta.setOnClickListener {
            val intent = Intent(this, QuartaTela::class.java)
            intent.putExtra("cliente", cliente) // Passando o cliente como extra
            startActivity(intent)
        }


    }
}
