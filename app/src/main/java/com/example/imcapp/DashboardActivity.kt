package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar?.hide()

        obterDados()
    }

    private fun obterDados(){
        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        findViewById<TextView>(R.id.dashboard_text_nome).text = arquivo.getString("nome", null)
        findViewById<TextView>(R.id.dashboard_text_profissao).text = arquivo.getString("profissao", null)
        findViewById<TextView>(R.id.dashboard_text_altura).text = arquivo.getFloat("altura", 0f).toString()
    }
}