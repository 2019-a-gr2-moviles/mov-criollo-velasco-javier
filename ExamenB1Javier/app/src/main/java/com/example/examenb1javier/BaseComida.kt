package com.example.examenb1javier

class BaseComida{
    companion object {
        val LST_EQUIPO:ArrayList<Comida> = ArrayList();
        var serial:Int= 1;
        var nombreUsuario:String = "";

        fun guardarUsuario(nombre:String){
            this.nombreUsuario = nombre;
        }

        fun agregarComida(equipo: Comida):ArrayList<Comida>{
            equipo.id = serial
            serial++
            LST_EQUIPO.add(equipo)
            return LST_EQUIPO
        }

        fun mostrarComida(): List<Comida> {
            return this.LST_EQUIPO
        }

        fun eliminarComida(id:Int){
            this.LST_EQUIPO.removeAll{ it.id == id }
        }

        fun actualizarComida(equipo: Comida){
            val indice = this.LST_EQUIPO.indexOfFirst { it.id == equipo.id }
            this.LST_EQUIPO[indice] = equipo
        }

    }

}