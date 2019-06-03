package com.example.examenmovilesb1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEntrarMain.setOnClickListener { ingresoUsuario() }

    }
    fun ingresoUsuario(){
        BaseComida.guardarUsuario(txtNombreMain.text.toString())
        val intentMenu = Intent(this, MenuActivity::class.java)
        intentMenu.putExtra("usuario", txtNombreMain.text.toString())
        startActivity(intentMenu)
    }
}
