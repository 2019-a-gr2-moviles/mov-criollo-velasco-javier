package com.example.examenb1javier

import android.os.Parcel
import android.os.Parcelable

class Comida(var id:Int?,
             var nombres:String,
             var apellidos:String,
             var fechaNacimiento:String,
             var cantidadAutos:Int,
             var licencia:String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        //return "NOMBRE: ${nombres} LIGA: ${apellidos} FECHA CREACION: ${fechaNacimiento} NUMERO COPAS:${cantidadAutos} CAMPEON ACTUAL:${licencia}"
        return "$nombres $apellidos"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nombres)
        parcel.writeString(apellidos)
        parcel.writeString(fechaNacimiento)
        parcel.writeInt(cantidadAutos)
        parcel.writeString(licencia)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comida> {
        override fun createFromParcel(parcel: Parcel): Comida {
            return Comida(parcel)
        }

        override fun newArray(size: Int): Array<Comida?> {
            return arrayOfNulls(size)
        }
    }
}