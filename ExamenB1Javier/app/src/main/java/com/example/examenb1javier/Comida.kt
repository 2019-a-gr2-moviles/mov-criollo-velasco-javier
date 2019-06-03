package com.example.examenb1javier

import android.os.Parcel
import android.os.Parcelable

class Comida(var id:Int?,
             var nombrePlato:String,
             var descripcionPlato:String,
             var nacionalidad:String,
             var numeroPersonas:Int,
             var picante:String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }
/*
    override fun toString(): String {
        //return "NOMBRE: ${nombrePlato} LIGA: ${descripcionPlato} FECHA CREACION: ${nacionalidad} NUMERO COPAS:${numeroPersonas} CAMPEON ACTUAL:${picante}"
        return "$nombrePlato $descripcionPlato"
    }
*/



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nombrePlato)
        parcel.writeString(descripcionPlato)
        parcel.writeString(nacionalidad)
        parcel.writeInt(numeroPersonas)
        parcel.writeString(picante)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "id=$id, nombrePlato='$nombrePlato', descripcionPlato='$descripcionPlato', nacionalidad='$nacionalidad', numeroPersonas=$numeroPersonas, picante='$picante'"
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