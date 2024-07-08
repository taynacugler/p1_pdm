package com.example.p1_taynacugler

import Cliente
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import banco.Banco
import banco.DAO

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //mostrar as classes e o banco antes
        //conexão com o banco
        val banco = Banco(this)
        val db = banco.writableDatabase
        val dao = DAO(this)

        //criei um objeto cliente e chamei o metodo inserir cliente do dao para teste
        val cliente = Cliente("44494836850", "Tayna", "11987654321", "tayna@example.com")
        dao.inserirCliente(cliente)

        //se eu clicar no botão cadastro da primeira página ele vai chama a "classe" intentCadastro que é a segunda tela (
        val button: Button = findViewById(R.id.bt_cadastro)
        button.setOnClickListener {
            val intentCadastro = Intent(this, SegundaTela::class.java)
            startActivity(intentCadastro)
        }


        val editTextCpf: EditText = findViewById(R.id.cpf_t1) //pega o cpf
        val buttonEntrar: Button = findViewById(R.id.bt_entrar) //quando eu clico no botão entrar

        buttonEntrar.setOnClickListener {
            val cpf = editTextCpf.text.toString() //transforma o cpf em string
            val clientePorCpf = dao.procurarClientePorCpf(cpf) //procura se existe um cpf no banco
            if (clientePorCpf != null) {
                //se não for nulo ou seja se existir um cliente com esse cpf ele mostra na tela que foi encontrado e chama a classe da terceira tela
                Toast.makeText(this, "Cliente encontrado", Toast.LENGTH_LONG).show()
                val intent = Intent(this, TerceiraTela::class.java)
                intent.putExtra("cliente", clientePorCpf) // Passando o cliente como extra pra não perder a referencia
                startActivity(intent)
            } else {
                Toast.makeText(this, "Cliente não encontrado", Toast.LENGTH_LONG).show() //se não achar ele avisa que não foi encontrado e continua na pagina inicial
            }
        }
    }
}



















