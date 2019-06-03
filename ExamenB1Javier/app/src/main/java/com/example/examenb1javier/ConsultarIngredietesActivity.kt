package com.example.examenb1javier

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_consultar_ingredientes.*

class ConsultarIngredietesActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var equipoRespaldo : Comida? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuario = intent.getStringExtra("usuario").toString()
        equipoRespaldo = intent.getParcelableExtra<Comida>("EquipoRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        setContentView(R.layout.activity_consultar_ingredientes)
        val adapter = ArrayAdapter<Ingredientes>(
            this,
            android.R.layout.simple_list_item_1,
            BaseIngredientes.mostrarIngredientes(padreId)
        )
        lstJugador.adapter = adapter;
        lstJugador.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val jugadorSeleccionado = parent.getItemAtPosition(position) as Ingredientes
            val intentJugadorSeleccionado = Intent(this, ActualizarIngredientesActivity::class.java)
            intentJugadorSeleccionado.putExtra("usuario", usuario)
            intentJugadorSeleccionado.putExtra("Ingredientes", jugadorSeleccionado)
            intentJugadorSeleccionado.putExtra("EquipoRespaldo", equipoRespaldo)
            startActivity(intentJugadorSeleccionado)
        }
    }
}
