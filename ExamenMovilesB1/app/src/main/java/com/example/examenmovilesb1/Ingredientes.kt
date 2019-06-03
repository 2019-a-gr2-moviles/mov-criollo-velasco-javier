package com.example.examenmovilesb1

import android.os.Parcel
import android.os.Parcelable

class Ingredientes (var id:Int?,
                    var nombreIngrediente:String,
                    var cantidad:Int,
                    var descripcionPreparacion:String,
                    var opcional:String,
                    var tipoIngrediente:String,
                    var necesitaRefrigeracion:String,
                    var comidaId:Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun toString(): String {
        return "Ingredientes(id=$id, nombreIngrediente='$nombreIngrediente', cantidad=$cantidad, descripcionPreparacion='$descripcionPreparacion', opcional='$opcional', tipoIngrediente='$tipoIngrediente', necesitaRefrigeracion='$necesitaRefrigeracion', comidaId=$comidaId)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nombreIngrediente)
        parcel.writeInt(cantidad)
        parcel.writeString(descripcionPreparacion)
        parcel.writeString(opcional)
        parcel.writeString(tipoIngrediente)
        parcel.writeString(necesitaRefrigeracion)
        parcel.writeInt(comidaId)
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