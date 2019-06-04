package com.example.examenb1javier

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar.*

class IngresarActivity : AppCompatActivity() {
    var usuario:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)
        usuario = intent.getStringExtra("usuario").toString()
        btnCrearCom.setOnClickListener { aceptarIngreso() }
        btnCancelarCom.setOnClickListener { cancelarIngreso()}
    }

    fun cancelarIngreso(){
        val intentCancelar= Intent(this, MenuActivity::class.java)
        intentCancelar.putExtra("usuario", usuario)
        startActivity(intentCancelar)
    }

    fun aceptarIngreso(){
        val equipo= Comida(id = null,
            nombrePlato = txtNombre.text.toString(),
            descripcionPlato = txtDesc.text.toString(),
            nacionalidad = txtNaciona.text.toString(),
            numeroPersonas = txtNumPer.text.toString().toInt(),
            picante = txtPican.text.toString())
        BaseComida.agregarComida(equipo)
        Toast.makeText(this, "Ingreso de Comida exitoso "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
}