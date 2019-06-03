package com.example.examenmovilesb1

class BaseComida {

    companion object {
        val listaComida:ArrayList<Comida> = ArrayList();
        var serial:Int= 1;
        var nombreUsuario:String = "";

        fun guardarUsuario(nombre:String){
            this.nombreUsuario = nombre;
        }

        fun agregarEquipo(comida: Comida):ArrayList<Comida>{
            comida.id = serial
            serial++
            listaComida.add(comida)
            return listaComida
        }

        fun mostrarComida(): List<Comida> {
            return this.listaComida
        }

        fun eliminarComida(id:Int){
            this.listaComida.removeAll{ it.id == id }
        }

        fun actualizarComida(comida: Comida){
            val indice = this.listaComida.indexOfFirst { it.id == comida.id }
            this.listaComida[indice] = comida
        }

    }
}