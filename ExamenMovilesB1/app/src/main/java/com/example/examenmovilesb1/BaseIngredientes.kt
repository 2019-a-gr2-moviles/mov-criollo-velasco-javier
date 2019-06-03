package com.example.examenmovilesb1

class BaseIngredientes {

    companion object {
        val listaIngredientes:ArrayList<Ingredientes> = ArrayList();
        var serial:Int= 1;

        fun agregarJugador(ingredientes: Ingredientes):ArrayList<Ingredientes>{
            ingredientes.id = serial
            serial++
            listaIngredientes.add(ingredientes)
            return listaIngredientes
        }

        fun mostrarIngredientes(padreId:Int): List<Ingredientes> {
            val listaFiltradaIngredientes = this.listaIngredientes.filter { it.comidaId ==  padreId}
            return listaFiltradaIngredientes
        }

        fun eliminarIngredientes(id:Int){
            this.listaIngredientes.removeAll{ it.id == id }
        }

        fun actualizarIngredientes(ingredientes: Ingredientes){
            val indice = this.listaIngredientes.indexOfFirst { it.id == ingredientes.id }
            this.listaIngredientes[indice] = ingredientes
        }

    }

}