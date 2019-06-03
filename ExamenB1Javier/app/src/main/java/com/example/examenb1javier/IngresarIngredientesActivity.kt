package com.example.examenb1javier

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_ingrediente.*

class IngresarIngredientesActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var equipoRespaldo : Comida? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_ingrediente)
        usuario = intent.getStringExtra("usuario").toString()
        equipoRespaldo = intent.getParcelableExtra<Comida>("EquipoRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        btnGuardar.setOnClickListener { guardarJugador() }
    }

    fun guardarJugador(){
        val jugador = Ingredientes(id = null,
            nombreIngrediente = txtNomIng.text.toString(),
            cantidad = txtCantIng.text.toString().toInt(),
            descripcionPreparacion = txtDescIng.text.toString(),
            opcional = txtOpciIng.text.toString(),
            tipoIngrediente = txtTipoIng.text.toString(),
            necesitaRefrigeracion = txtRefriIng.text.toString(),
            comidaId = padreId)
        BaseIngredientes.agregarIngredientes(jugador)
        Toast.makeText(this, "Ingreso de Ingrediente exitoso "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }
}
