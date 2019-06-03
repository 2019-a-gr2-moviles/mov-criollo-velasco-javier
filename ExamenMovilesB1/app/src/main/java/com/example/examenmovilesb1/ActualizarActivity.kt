package com.example.examenmovilesb1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar.*

class ActualizarActivity : AppCompatActivity() {

    var padreId : Int = 0
    var usuario :String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)

        usuario = intent.getStringExtra("usuario").toString()
        val equipoRecibida = intent.getParcelableExtra<Comida>("Equipo")
        txtNombre2.setText(equipoRecibida.nombrePlato.toString())
        txtLiga2.setText(equipoRecibida.descripcionPlato.toString())
        txtFechaCreacion2.setText(equipoRecibida.nacionalidad.toString())
        txtNumCopInter2.setText(equipoRecibida.numeroPersonas.toString())
        txtCampeonAct2.setText(equipoRecibida.picante.toString())
        padreId = equipoRecibida.id!!;
        btnActualizar2.setOnClickListener { actualizarEquipo() }
        btnEliminar2.setOnClickListener { eliminarEquipo() }
        btnCrearJugador2.setOnClickListener { crearJugador() }
       // btnGestionarJugador2.setOnClickListener { gestionarJugador() }
       // btnMenuRetorno2.setOnClickListener { retorno() }
    }

    fun actualizarEquipo(){
        val actualizarEquipo = Comida(id = padreId,
            nombrePlato  = txtNombre2.text.toString(),
            descripcionPlato  = txtLiga2.text.toString(),
            nacionalidad  = txtFechaCreacion2.text.toString(),
            numeroPersonas  = txtNumCopInter2.text.toString().toInt(),
            picante  = txtCampeonAct2.text.toString()
        )
        BaseComida.actualizarComida(actualizarEquipo)
        Toast.makeText(this, "Actualización de Comida exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun eliminarEquipo(){
        BaseComida.eliminarComida(padreId);
        Toast.makeText(this, "Eliminación de comida exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun crearJugador(){
        val equipoRespaldo = Comida(id = padreId,
            nombrePlato  = txtNombre2.text.toString(),
            descripcionPlato  = txtLiga2.text.toString(),
            nacionalidad  = txtFechaCreacion2.text.toString(),
            numeroPersonas  = txtNumCopInter2.text.toString().toInt(),
            picante  = txtCampeonAct2.text.toString()
        )
        val retorno = Intent(this, IngresarAutoActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }
}
