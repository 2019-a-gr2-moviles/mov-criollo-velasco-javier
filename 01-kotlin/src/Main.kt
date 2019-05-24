fun main(args: Array<String>) {
    println("Hello, world!")

    /*Esto es un comentario en
    bloque
     */

    //esto es un comentario
    //linea a linea
    //----------------------------VARIABLES----------------------
    //variable mutable
    var nombre = "Adrian"
    nombre = "Vicente"

    //variable inmutable
    val nombreI = "Adrian"
    //nombreI="Vicente"

    //------------------------------Tipos de datos----------------------------
    val apellido: String = "Eguez"
    val edad: Int = 29
    val sueldo: Double = 1.21
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos = null

    //------------------------------Condicionales---------------------
    //-----------if-------------
    //condicional if-else en bloque
    if (apellido == "Eguez" || nombre == "Adrian") {
        println("Verdadero")
    } else {
        println("Falso")
    }

    //condicional if-else en una sola linea
    val tieneNombreYApellido = if (apellido != null && nombre != null) "ok" else "no"

    println(tieneNombreYApellido)

    estaJalado(1.0)

    estaJalado(8.0)

    estaJalado(0.0)

    estaJalado(7.0)

    estaJalado(10.0)


}

//---------when------
fun estaJalado(nota: Double):Double {
    //when usando valores exactos
    when (nota) {
        0.0 -> {
            println("Dios mio que vago!")
        }
        7.0 -> {
            println("Pasaste con las justas")
        }
        10.0 -> {
            println("Genial :D Felicitaciones")
        }
        else -> {
            println("Tu nota es: $nota") //no utilizamos ${nota} porque solo se la usa en este caso ${nota.algo}
        }
    }
    // when usando rangos
    when {
        nota >= 0 && nota < 7 -> println("Dios mio que vago!")
        nota >= 7.0 && nota < 10 -> println("Pasaste con las justas")
        nota == 10.0 -> println("Genial :D Felicitaciones")
        else -> println("Tu nota es: $nota")

    }

    return nota
}
