package com.example.examenmovilesb1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_ingredientes.*

class IngresarIngredientesActivity : AppCompatActivity() {


    var id :Int = 0;
    var idPadre :Int = 0
    var usuario :String = "";
    var equipoRespaldo : Comida? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_ingredientes)

        usuario = intent.getStringExtra("usuario").toString()
        val jugadorRecibido = intent.getParcelableExtra<Ingredientes>("Ingredientes")
        equipoRespaldo = intent.getParcelableExtra<Comida>("EquipoRespaldo")
        txtNombreIngIng.setText(jugadorRecibido.nombreIngrediente.toString())
        txtCantidadIngIng.setText(jugadorRecibido.cantidad.toString())
        txtDescripcionIngIng.setText(jugadorRecibido.descripcionPreparacion.toString())
        txtOpcionalIngIng.setText(jugadorRecibido.opcional.toString())
        txtTipoIngIng.setText(jugadorRecibido.tipoIngrediente.toString())
        txtRefriIngIng.setText(jugadorRecibido.necesitaRefrigeracion.toString())
        id = jugadorRecibido.id.toString().toInt()
        idPadre = jugadorRecibido.comidaId.toString().toInt()
        btnActualizarIngIng.setOnClickListener { actualizarJugador() }
        btnEliminarIngIng.setOnClickListener { eliminarJugador() }
    }

    fun actualizarJugador(){
        val jugador = Ingredientes(id = id,
            nombreIngrediente = txtNombreIngIng.text.toString(),
            cantidad = txtCantidadIngIng.text.toString().toInt(),
            descripcionPreparacion = txtDescripcionIngIng.text.toString(),
            opcional = txtOpcionalIngIng.text.toString(),
            tipoIngrediente = txtTipoIngIng.text.toString(),
            necesitaRefrigeracion = txtRefriIngIng.text.toString(),
            comidaId = idPadre)
        BaseIngredientes.actualizarIngredientes(jugador)
        Toast.makeText(this, "Actualización de Ingrediente exitosa "+usuario, Toast.LENGTH_SHORT).show()
       /* val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)*/
    }

    fun eliminarJugador(){
        BaseIngredientes.eliminarIngredientes(id)
        Toast.makeText(this, "Eliminación de Ingrediente exitosa "+usuario, Toast.LENGTH_SHORT).show()
        /*val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)*/
    }
}
