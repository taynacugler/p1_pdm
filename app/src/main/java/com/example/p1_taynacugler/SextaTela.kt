package com.example.p1_taynacugler

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import banco.DAO
import com.example.app_cugler.classes.Pamonha

class SextaTela : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        val id: Int = intent.getIntExtra("id", -1)

        if (id == -1) {
            Toast.makeText(this, "ID inválido", Toast.LENGTH_LONG).show()
            return
        }

        val pesoMostrar: TextView = findViewById(R.id.pesoQj)
        val recheioMostrar: TextView = findViewById(R.id.tipoDoRecheio)
        val idMostrar: TextView = findViewById(R.id.id_pag6)

        val dao = DAO(this)

        val pamonha: Pamonha? = dao.procurarPamonhaPorID(id)
//
        if (pamonha != null) {
            pesoMostrar.text = "Peso do Queijo: ${pamonha.pesoDeQueijo}"
            recheioMostrar.text = "Tipo de Recheio: ${pamonha.tipoDeRecheio}"
            idMostrar.text = "ID: ${pamonha.idPamonha}"
        } else {
            Toast.makeText(this, "Não foi possível achar pedido com esse ID", Toast.LENGTH_LONG).show()
        }
    }
}