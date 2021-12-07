package com.example.imcapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var editEmail : EditText
    lateinit var editSenha : EditText
    lateinit var buttonEntrar : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()

        val botaoCriarConta = findViewById<View>(R.id.botao_criar_conta)

        editEmail = findViewById(R.id.text_email)
        editSenha = findViewById(R.id.text_senha)
        buttonEntrar = findViewById(R.id.botao_entrar)

        buttonEntrar.setOnClickListener {
            login()
        }

        //cria um ouvidor
        botaoCriarConta.setOnClickListener{

            //cria uma intencao e troca de tela
            val intent = Intent(this, CadastroUsuarioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        val email = arquivo.getString("email", null)
        val senha = arquivo.getString("senha", null)

        if(editEmail.text.toString() == email && editSenha.text.toString() == senha){
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "N foi mano...", Toast.LENGTH_SHORT).show()
        }
    }
}