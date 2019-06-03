package com.example.examenb1javier

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_consultar.*

class ConsultarActivity : AppCompatActivity() {
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)
        usuario = intent.getStringExtra("usuario").toString()
        val adapter = ArrayAdapter<Comida>(
            this,
            android.R.layout.simple_list_item_1,
            BaseComida.mostrarComida()
        )
        lstView.adapter = adapter;
        lstView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            Log.i("list-view","Posicion $position")

            Snackbar.make(view, "Posicion $position", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            val equipoSeleccionada = parent.getItemAtPosition(position) as Comida
            val intentEquipoSeleccionada = Intent(this, ActualizarActivity::class.java)
            intentEquipoSeleccionada.putExtra("Equipo", equipoSeleccionada)
            intentEquipoSeleccionada.putExtra("usuario", usuario)
            startActivity(intentEquipoSeleccionada)
        }


    }
}
