package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.imcapp.util.dataAtualBrasil
import java.text.SimpleDateFormat
import java.util.*

class PesagemActivity : AppCompatActivity() {
    lateinit var textData: TextView
    lateinit var spinnerNivelAtividade: Spinner
    lateinit var inputPesoAtual: EditText
    lateinit var buttonSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem2)

        supportActionBar?.hide()

        textData = findViewById(R.id.caixa_hoje)
        spinnerNivelAtividade = findViewById(R.id.spinner_atividade_atual)
        inputPesoAtual = findViewById(R.id.input_peso_atual)
        buttonSalvar = findViewById(R.id.button_salvar_peso)

        textData.text = dataAtualBrasil()

        buttonSalvar.setOnClickListener{
            registrarPeso()
        }
    }

    private fun registrarPeso() {
        val cadastro = getSharedPreferences("cadastro", MODE_PRIVATE)
        val editor = cadastro.edit()

        editor.putString("data_pesagem", dataAtualBrasil())
        editor.putString("peso", inputPesoAtual.text.toString())
        editor.putInt("nivel", spinnerNivelAtividade.selectedItemPosition)

        editor.commit()

        Toast.makeText(this, "foi, gravou", Toast.LENGTH_SHORT).show()
        finish()
    }

}