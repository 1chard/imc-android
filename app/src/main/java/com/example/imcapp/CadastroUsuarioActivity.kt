package com.example.imcapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class CadastroUsuarioActivity : AppCompatActivity() {

    private lateinit var editEmail: EditText
    private lateinit var editSenha: EditText
    private lateinit var editNome: EditText
    private lateinit var editProfissao: EditText
    private lateinit var editAltura: EditText
    private lateinit var editDataNascimento: EditText
    private lateinit var radioFeminino: RadioButton
    private lateinit var radioMasculino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        editEmail = findViewById(R.id.cadastro_usuario_email)
        editSenha = findViewById(R.id.cadastro_usuario_senha)
        editNome = findViewById(R.id.cadastro_usuario_nome)
        editProfissao = findViewById(R.id.cadastro_usuario_profissao)
        editAltura = findViewById(R.id.cadastro_usuario_altura)
        editDataNascimento = findViewById(R.id.cadastro_usuario_data_nascimento)
        radioFeminino = findViewById(R.id.cadastro_usuario_radio_feminino)
        radioMasculino = findViewById(R.id.cadastro_usuario_radio_masculino)

        // abre um calendario ao clicar num botao
        editDataNascimento.setOnClickListener{
            abrirCalendario()
        }
    }

    private fun abrirCalendario(){
        val calendario = Calendar.getInstance()

        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        val datepicker = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        val mesFinal = DecimalFormat("00").format(month + 1)
                        val diaFinal = DecimalFormat("00").format(dayOfMonth)

            editDataNascimento.setText("${diaFinal}/${mesFinal}/${year}")
        }, ano, mes, dia)



        datepicker.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //salva os dados na sharedPreferences
        val dados = getSharedPreferences("cadastro", MODE_PRIVATE)

        //cria um editor para o arquivo
        val editor = dados.edit()
        editor.putString("email", editEmail.text.toString())
        editor.putString("senha", editSenha.text.toString())
        editor.putString("nome", editNome.text.toString())
        editor.putFloat("altura", editAltura.text.toString().toFloat())
        editor.putString("profissao", editProfissao.text.toString())
        editor.putString("nascimento", editDataNascimento.text.toString())
        editor.putString("sexo", if(radioFeminino.isChecked) "F" else "M")
        editor.apply()

        Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        finish()

        return true
    }


}