@file:Suppress("UNREACHABLE_CODE")

import java.nio.file.attribute.DosFileAttributeView
import java.util.*

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


    holaMundo("Fernando")

    holaMundoAvanzado(2)

    val total=sumarDosNumeros(1,3000000)

   print( "\n\n\n$total\n\n\n")



    val arregloCumpleanos =intArrayOf(1,2,3,4)

    val arregloTodo :Array<Any> = arrayOf(1,"asd",10.2,true)



    arregloCumpleanos[0]=5

    arregloCumpleanos.set(0,5)

    println(arregloTodo[0])



//arregloTodo=arrayOf(5,2,3,4)



//valfecha=Date()

//fecha.time=11231231

//fecha.year=2000

//fecha=Date(1989,10,10)



//valnotas:ArrayList<Int>=arrayListOf<Int>(1,2,3,4,5,6)



    val notas=arrayListOf(1,2,3,4,5,6)

    notas.forEach { nota: Int ->

        println(nota)

    }

    //para indices
    notas.forEachIndexed { indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")


    }
//Operadores
    //MAP = ITERA y modifica el arreglo

    //sumar mas 1 a cada elemento del arreglo Notas
    val notasDos = notas.map { nota ->
        nota + 1


    }

    notasDos.forEach {
        println("\tNotas 2: $it")
    }


    //Sumar +1 a los impares y +2 a los pares

    val notasTres = notas.map { nota ->
        if (nota%2 != 0) nota + 1
        else         nota + 2


    }

    notasTres.forEach {
        println("\ttNotas 3: $it")
    }

    //para imprimir elementos mayores que 2
   val respuestaFilter =  notas.filter {
        //aplicamos la condicion a cada uno de los elementos
       it > 2
    }

    respuestaFilter.forEach { println("\t\t$it")

    }
    println()


    //para imprimir elementos mayores que 2   menor que 5
    val respuestaFilter2 =  notas.filter {
        //aplicamos la condicion a cada uno de los elementos
        //it > 2  && it <5
        it in 3..4

    }

    respuestaFilter2.forEach { println("\t\t$it") }









    //-----------------------------------------

    val novias = arrayListOf(1,2,2,3,4,5)
    //existira algun elemento que sea igual a 3

    val respuestaNovia: Boolean = novias.any {
        it == 3

    }

    println(respuestaNovia)


    //todos los tazos son mayores a 1
    val tazos = arrayListOf(1,2,3,4,5,6,7)
    val respuestaTazos: Boolean =tazos.all {

        it > 1
    }

    println(respuestaTazos)



    //pueden sumar todos los tazos

    val totalTazos: Int = tazos.reduce { valorAcumulado, tazo ->

        //por defecto valoracumulado tiene valor de 0

        //en la primera iteracion valoracumulado vale 0 y el primer elemento es 1 entonces devuelve 1

        valorAcumulado + tazo
    }


    println(totalTazos)





}

fun estaJalado(nota:Double):Double{

when (nota) {
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
return nota

}

fun holaMundo(mensaje: String):Unit{
    println("Mensaje: $mensaje.")
}
//
fun holaMundoAvanzado(mensaje: Any):Unit{
    println("Mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno:Int, numDos:Int):Int{
return numUno + numDos

}