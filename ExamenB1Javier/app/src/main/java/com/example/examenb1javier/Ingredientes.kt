package com.example.examenb1javier

import android.os.Parcel
import android.os.Parcelable

class Ingredientes(var id:Int?,
                   var chasis:Int,
                   var marca:String,
                   var colorUno:String,
                   var colorDos:String,
                   var modelo:String,
                   var anio:Int,
                   var idConductor:Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun toString(): String {
        //  return "Número Camiseta: ${chasis} Nombre Ingredientes: ${colorUno} Poder: ${colorDos} Fecha Ingreso:${modelo} Goles:${anio}"
        return "$marca anio: $anio"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(chasis)
        parcel.writeString(marca)
        parcel.writeString(colorUno)
        parcel.writeString(colorDos)
        parcel.writeString(modelo)
        parcel.writeInt(anio)
        parcel.writeInt(idConductor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ingredientes> {
        override fun createFromParcel(parcel: Parcel): Ingredientes {
            return Ingredientes(parcel)
        }

        override fun newArray(size: Int): Array<Ingredientes?> {
            return arrayOfNulls(size)
        }
    }
}
