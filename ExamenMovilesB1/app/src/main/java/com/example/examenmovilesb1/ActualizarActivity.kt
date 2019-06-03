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
        txtNombre.setText(equipoRecibida.nombrePlato.toString())
        txtLiga.setText(equipoRecibida.descripcionPlato.toString())
        txtFechaCreacion.setText(equipoRecibida.nacionalidad.toString())
        txtNumCopInter.setText(equipoRecibida.numeroPersonas.toString())
        txtCampeonAct.setText(equipoRecibida.picante.toString())
        padreId = equipoRecibida.id!!;
        btnActualizar.setOnClickListener { actualizarEquipo() }
        btnEliminar.setOnClickListener { eliminarEquipo() }
        btnCrearJugador.setOnClickListener { crearJugador() }
        btnGestionarJugador.setOnClickListener { gestionarJugador() }
        btnMenuRetorno.setOnClickListener { retorno() }
    }


    fun actualizarEquipo(){
        val actualizarEquipo = Comida(id = padreId,
            nombrePlato = txtNombre.text.toString(),
            descripcionPlato = txtLiga.text.toString(),
            nacionalidad = txtFechaCreacion.text.toString(),
            numeroPersonas = txtNumCopInter.text.toString().toInt(),
            picante = txtCampeonAct.text.toString()
        )
        BaseComida.actualizarComida(actualizarEquipo)
        Toast.makeText(this, "Actualización exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun eliminarEquipo(){
        BaseComida.eliminarComida(padreId);
        Toast.makeText(this, "Eliminación exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun crearJugador(){
        val equipoRespaldo = Comida(id = padreId,
            nombrePlato = txtNombre.text.toString(),
            descripcionPlato = txtLiga.text.toString(),
            nacionalidad = txtFechaCreacion.text.toString(),
            numeroPersonas = txtNumCopInter.text.toString().toInt(),
            picante = txtCampeonAct.text.toString()
        )
        val retorno = Intent(this, IngresarIngredientesActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun gestionarJugador(){
        val equipoRespaldo = Comida(id = padreId,
            nombrePlato = txtNombre.text.toString(),
            descripcionPlato = txtLiga.text.toString(),
            nacionalidad = txtFechaCreacion.text.toString(),
            numeroPersonas = txtNumCopInter.text.toString().toInt(),
            picante = txtCampeonAct.text.toString()
        )
        val retorno = Intent(this, ConsultarIngredientesActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun retorno(){
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
}
