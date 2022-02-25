package uz.pdp.uiexam

import android.os.Parcel
import android.os.Parcelable

data class Features(val image:Int,val description:String,val id:Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(description)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Features> {
        override fun createFromParcel(parcel: Parcel): Features {
            return Features(parcel)
        }

        override fun newArray(size: Int): Array<Features?> {
            return arrayOfNulls(size)
        }
    }
}