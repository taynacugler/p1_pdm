package com.example.p1_taynacugler

import Cliente
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import banco.DAO

class QuartaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val cliente: Cliente? = intent.getParcelableExtra("cliente")

        val nomeTextView: TextView = findViewById(R.id.nome_t4)
        val cpfTextView: TextView = findViewById(R.id.cpf_t4)
        val telefoneTextView: TextView = findViewById(R.id.telefone_t4)
        val emailTextView: TextView = findViewById(R.id.email_t4)

        nomeTextView.text = "Nome: ${cliente?.nome}"
        cpfTextView.text = "CPF: ${cliente?.cpf}"
        telefoneTextView.text = "Telefone: ${cliente?.telefone}"
        emailTextView.text = "E-mail: ${cliente?.email}"


        val botaoSair: Button = findViewById(R.id.voltar_btt_t4)
        botaoSair.setOnClickListener {
            finish()
        }
        val botaoAtt: Button = findViewById(R.id.att_bt)
        val dao = DAO (this)
        botaoAtt.setOnClickListener {
            val nome: EditText = findViewById(R.id.getNome)
            val telefone: EditText = findViewById(R.id.getTelefone)
            val email: EditText = findViewById(R.id.getEmail)

            val nomeText = nome.text.toString()
            val telefoneText = telefone.text.toString()
            val emailText = email.text.toString()

            //pegar o cpf do cliente
            if (cliente != null) {
                val clienteAtt = Cliente(cliente.cpf, nomeText, telefoneText, emailText)
                dao.atualizarCliente(clienteAtt)
            }

        }
        val botaoDelete: Button = findViewById((R.id.delete_bt))
        botaoDelete.setOnClickListener {
            //pegar cpf do cliente
            if (cliente != null) {
                dao.excluirCliente(cliente.cpf)
            }
        }
    }
}
