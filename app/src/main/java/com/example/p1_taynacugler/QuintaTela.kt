package com.example.p1_taynacugler

import Cliente
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import banco.DAO
import com.example.app_cugler.classes.Pamonha

class QuintaTela : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val cliente: Cliente? = intent.getParcelableExtra("cliente")

        val botaoPedido: Button = findViewById(R.id.pedir)
        botaoPedido.setOnClickListener {
            val recheio: EditText = findViewById(R.id.recheio)
            val queijo: EditText = findViewById(R.id.queijo)

            val recheioText = recheio.text.toString()
            val queijoText = queijo.text.toString()

            val queijoPeso = queijoText.toFloatOrNull()

            val cpf = cliente?.cpf
            val pedido =
                Pamonha(
                    tipoDeRecheio = recheioText,
                    pesoDeQueijo = queijoPeso,
                    fkCpf = cpf.toString()
                )

            val dao = DAO(this)
            dao.inserirPamonha(pedido)
            dao.mostrarUmaPamonha(1)
            Toast.makeText(this, "Inserido", Toast.LENGTH_LONG).show()


        }
//
//
        val botaoSair: Button = findViewById(R.id.sair)
        botaoSair.setOnClickListener {
            finish()
        }
        val botaoAtt: Button = findViewById((R.id.bt_atualizar))
        botaoAtt.setOnClickListener {
            val idPedido: EditText = findViewById(R.id.getID)
            val idString = idPedido.text.toString()
            val id = idString.toIntOrNull()

            if (id == null) {
                Toast.makeText(this, "ID inválido", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val recheio: EditText = findViewById(R.id.tipoRecheio)
            val peso: EditText = findViewById(R.id.pesoQueijo)

            val recheioString = recheio.text.toString()
            val pesoString = peso.text.toString()

            val pesoFloat = pesoString.toFloatOrNull()
            val cpf = cliente?.cpf
            val pedidoAtt = Pamonha(recheioString, pesoFloat, cpf.toString())

            val dao = DAO(this)
            val pamonha: Pamonha? = dao.procurarPamonhaPorID(id)
            if (pamonha != null) {
                dao.atualizarPamonha(pedidoAtt, id)
            } else {
                Toast.makeText(this, "Não foi possível achar pedido com esse ID", Toast.LENGTH_LONG)
                    .show()
            }
        }

        val botaoDelete: Button = findViewById(R.id.deletar)
        botaoDelete.setOnClickListener {
            val idText: EditText = findViewById(R.id.getID)
            val idString = idText.toString()
            val id = idString.toInt()
            val dao = DAO(this)
            var pamonha: Pamonha? = dao.procurarPamonhaPorID(id)
            if (pamonha != null) {
                dao.excluirPamonha(id)
            } else {
                Toast.makeText(this, "Não foi possível achar pedido com esse id", Toast.LENGTH_LONG)
                    .show()
            }
        }

        val botaoMostrar: Button = findViewById(R.id.bt_mostrar)
        botaoMostrar.setOnClickListener {
            val idPedido: EditText = findViewById(R.id.getID)
            val idString = idPedido.text.toString()
            val id = idString.toIntOrNull()

            if (id == null) {
                Toast.makeText(this, "ID inválido", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else {
                Toast.makeText(this, "ID valido", Toast.LENGTH_LONG).show()
                val intentMostrar = Intent(this, SextaTela::class.java)
                intentMostrar.putExtra("id", id) //
                startActivity(intentMostrar)
            }
        }
    }
}