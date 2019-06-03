package com.example.examenb1javier

class BaseComida{
    companion object {
        val LST_EQUIPO:ArrayList<Comida> = ArrayList();
        var serial:Int= 1;
        var nombreUsuario:String = "";

        fun guardarUsuario(nombre:String){
            this.nombreUsuario = nombre;
        }

        fun agregarEquipo(equipo: Comida):ArrayList<Comida>{
            equipo.id = serial
            serial++
            LST_EQUIPO.add(equipo)
            return LST_EQUIPO
        }

        fun mostrarEquipo(): List<Comida> {
            return this.LST_EQUIPO
        }

        fun eliminarEquipo(id:Int){
            this.LST_EQUIPO.removeAll{ it.id == id }
        }

        fun actualizarEquipo(equipo: Comida){
            val indice = this.LST_EQUIPO.indexOfFirst { it.id == equipo.id }
            this.LST_EQUIPO[indice] = equipo
        }

    }

}