package com.example.examenb1javier

class BaseIngredientes {
    companion object {
        val LST_INGREDIENTES:ArrayList<Ingredientes> = ArrayList();
        var serial:Int= 1;

        fun agregarJugador(ingredientes: Ingredientes):ArrayList<Ingredientes>{
            ingredientes.id = serial
            serial++
            LST_INGREDIENTES.add(ingredientes)
            return LST_INGREDIENTES
        }

        fun mostrarJugador(padreId:Int): List<Ingredientes> {
            val lstFiltradaJugador = this.LST_INGREDIENTES.filter { it.idConductor ==  padreId}
            return lstFiltradaJugador
        }

        fun eliminarJugador(id:Int){
            this.LST_INGREDIENTES.removeAll{ it.id == id }
        }

        fun actualizarJugador(ingredientes: Ingredientes){
            val indice = this.LST_INGREDIENTES.indexOfFirst { it.id == ingredientes.id }
            this.LST_INGREDIENTES[indice] = ingredientes
        }

    }

}