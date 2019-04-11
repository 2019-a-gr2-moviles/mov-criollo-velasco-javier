fun main(args : Array<String>){
    println("Hello, world!!!")


    //Mutables
    var nombre = "Adrian"
    nombre = "Vicente"
    //Inmutables
    val nombreI = "Adrian"
    //nombreI = "Vicente"


    val apellido = "Eguez"
    val edad: Int = 29
    val sueldo: Double = 1.21
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos = null


    //condicionales
    if(apellido == "Eguez"){
        println("Verdadero")

    }else{
        println("Falso")
    }

    //if else en la misma linea
    val tieneNombreYApellido = if (apellido != null && nombre != null) "ok" else "no"
    println(tieneNombreYApellido)
    estaJalado(1.0)
    estaJalado( 0.0)

    estaJalado(0.0)

    estaJalado( 7.0)

    estaJalado(10.0)
}

fun estaJalado(nota:Double){
    when (nota){
        7.0 -> {
            println("Pasaste con las justas")
        }
        10.0 -> {
            println("Genial :D Felicidades!")
        }

        0.0 -> {
            println("Dios mio que vago!")

        }
        else -> {
            println("Tu nota es: $nota")
            //usar lo siguiente si es nota un clase y se llama a una variable dentro de esa clase
            //println("Tu nota es: ${nota}")
        }
    }

}

