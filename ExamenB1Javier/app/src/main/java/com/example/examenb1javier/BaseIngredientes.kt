package com.example.examenb1javier

class BaseIngredientes {
    companion object {
        val LST_INGREDIENTES:ArrayList<Ingredientes> = ArrayList();
        var serial:Int= 1;

        fun agregarIngredientes(ingredientes: Ingredientes):ArrayList<Ingredientes>{
            ingredientes.id = serial
            serial++
            LST_INGREDIENTES.add(ingredientes)
            return LST_INGREDIENTES
        }

        fun mostrarIngredientes(padreId:Int): List<Ingredientes> {
            val lstFiltradaJugador = this.LST_INGREDIENTES.filter { it.comidaId ==  padreId}
            return lstFiltradaJugador
        }

        fun eliminarIngredientes(id:Int){
            this.LST_INGREDIENTES.removeAll{ it.id == id }
        }

        fun actualizarIngredientes(ingredientes: Ingredientes){
            val indice = this.LST_INGREDIENTES.indexOfFirst { it.id == ingredientes.id }
            this.LST_INGREDIENTES[indice] = ingredientes
        }

    }

}