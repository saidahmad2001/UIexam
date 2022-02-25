package uz.pdp.uiexam

import android.content.Context
import androidx.core.content.edit

class SharedPref(context: Context) {

    private var pref = context.getSharedPreferences("entry", Context.MODE_PRIVATE)

    var isSaved: Boolean
        get() = pref.getBoolean("isSaved", false)
        set(value) = pref.edit { this.putBoolean("isSaved", value) }

}