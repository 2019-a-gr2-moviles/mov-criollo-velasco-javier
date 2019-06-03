package com.example.examenmovilesb1

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
        txtNombreIngAct.setText(jugadorRecibido.nombreIngrediente.toString())
        txtCantidadIngAct.setText(jugadorRecibido.cantidad.toString())
        txtDescripcionIngAct.setText(jugadorRecibido.descripcionPreparacion.toString())
        txtOpcionalIngAct.setText(jugadorRecibido.opcional.toString())
        txttipoIngAct.setText(jugadorRecibido.tipoIngrediente.toString())
        txtRefriIntAct.setText(jugadorRecibido.necesitaRefrigeracion.toString())
        id = jugadorRecibido.id.toString().toInt()
        idPadre = jugadorRecibido.comidaId.toString().toInt()
        btnActualizarIngAct.setOnClickListener { actualizarJugador() }
        btnEliminarIngAct.setOnClickListener { eliminarJugador() }
    }

    fun actualizarJugador(){
        val jugador = Ingredientes(id = id,
            nombreIngrediente = txtNombreIngAct.text.toString(),
            cantidad = txtCantidadIngAct.text.toString().toInt(),
            descripcionPreparacion = txtDescripcionIngAct.text.toString(),
            opcional = txtOpcionalIngAct.text.toString(),
            tipoIngrediente = txttipoIngAct.text.toString(),
            necesitaRefrigeracion = txtRefriIntAct.text.toString(),
            comidaId = idPadre)
        BaseIngredientes.actualizarIngredientes(jugador)
        Toast.makeText(this, "Actualización de Ingrediente exitosa "+usuario, Toast.LENGTH_SHORT).show()
        /*val retorno = Intent(this, ActualizarActivity::class.java)
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
