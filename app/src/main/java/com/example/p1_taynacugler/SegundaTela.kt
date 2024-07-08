package com.example.p1_taynacugler

import Cliente
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import banco.DAO

//quando clica no cadastro vem pra essa tela
class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2) //aparece a tela 2

        val button: Button = findViewById(R.id.voltar_bt) //se clicar no botão voltar ele faz "finish" e vai pra
        button.setOnClickListener {
            finish()
        }
        val botaoCad: Button = findViewById(R.id.cadastro_bt) //botão de cadastro
        botaoCad.setOnClickListener{
            val dao = DAO (this) //objeto dao para chamar o metodo

            //pega os valores que colocar na tela

            val nome: EditText = findViewById(R.id.nome_t2)
            val cpf: EditText = findViewById(R.id.cpf_t2)
            val telefone: EditText = findViewById(R.id.telefone_t2)
            val email: EditText = findViewById(R.id.email_t2)

            //transforma tudo em string
            val nomeText = nome.text.toString()
            val cpfText = cpf.text.toString()
            val telefoneText = telefone.text.toString()
            val emailText = email.text.toString()

            val clienteTeste: Cliente? = dao.procurarClientePorCpf(cpfText) //ele procura o cliente por cpf

            //  se o cliente voltar não nulo quer dizer que ja existe
            if (clienteTeste == null) {
                //cria um objeto cliente
                val cliente = Cliente (
                    nome = nomeText,
                    cpf = cpfText,
                    telefone = telefoneText,
                    email = emailText
                )
                dao.inserirCliente(cliente)
                Toast.makeText(this, "Cliente inserido", Toast.LENGTH_LONG).show()
                //volta pra pagina inicial
                finish()
            }
            else {
                //avisa que ja existe um
                Toast.makeText(this, "Já existe um cliente com esse cpf", Toast.LENGTH_LONG).show()
            }

        }

    }
}