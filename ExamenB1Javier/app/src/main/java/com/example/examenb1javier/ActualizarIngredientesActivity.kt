package com.example.examenb1javier

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar_ingredientes.*

class ActualizarIngredientesActivity : AppCompatActivity() {
    var id :Int = 0;
    var idPadre :Int = 0
    var usuario :String = "";
    var equipoRespaldo : Comida? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_ingredientes)
        usuario = intent.getStringExtra("usuario").toString()
        val jugadorRecibido = intent.getParcelableExtra<Ingredientes>("Ingredientes")
        equipoRespaldo = intent.getParcelableExtra<Comida>("EquipoRespaldo")
        txtNomIng.setText(jugadorRecibido.nombreIngrediente.toString())
        txtCantIng.setText(jugadorRecibido.cantidad.toString())
        txtDescIng.setText(jugadorRecibido.descripcionPreparacion.toString())
        txtOpciIng.setText(jugadorRecibido.opcional.toString())
        txtTipoIng.setText(jugadorRecibido.tipoIngrediente.toString())
        txtRefriIng.setText(jugadorRecibido.necesitaRefrigeracion.toString())
        id = jugadorRecibido.id.toString().toInt()
        idPadre = jugadorRecibido.comidaId.toString().toInt()
        btnActualizarJugador.setOnClickListener { actualizarJugador() }
        btnEliminarJugador.setOnClickListener { eliminarJugador() }
    }

    fun actualizarJugador(){
        val jugador = Ingredientes(id = id,
            nombreIngrediente = txtNomIng.text.toString().toInt(),
            cantidad = txtCantIng.text.toString(),
            descripcionPreparacion = txtDescIng.text.toString(),
            opcional = txtOpciIng.text.toString(),
            tipoIngrediente = txtTipoIng.text.toString(),
            necesitaRefrigeracion = txtRefriIng.text.toString().toInt(),
            comidaId = idPadre)
        BaseIngredientes.actualizarIngredientes(jugador)
        Toast.makeText(this, "Actualización de Ingrediente exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }

    fun eliminarJugador(){
        BaseIngredientes.eliminarIngredientes(id)
        Toast.makeText(this, "Eliminación de Ingrediente exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }
}
