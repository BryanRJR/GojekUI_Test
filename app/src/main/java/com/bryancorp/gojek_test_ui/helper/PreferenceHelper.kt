package com.bryancorp.gojek_test_ui.helper

import android.content.Context
import android.content.SharedPreferences
import com.bryancorp.gojek_test_ui.helper.Constant.Companion.PREF_EMAIL
import com.bryancorp.gojek_test_ui.helper.Constant.Companion.PREF_IS_LOGIN
import com.bryancorp.gojek_test_ui.helper.Constant.Companion.PREF_NUMBER
import com.bryancorp.gojek_test_ui.helper.Constant.Companion.PREF_PASSWORD
import com.bryancorp.gojek_test_ui.helper.Constant.Companion.PREF_USERNAME

class PreferenceHelper(context: Context) {

    private val PREF_NAME = "sharedPreference"
    private val sharedPref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String, value: String){
        editor.putString(key, value).apply()
    }

    fun getString(key: String) : String? {
        return sharedPref.getString(key, null)
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value).apply()
    }

    fun getBoolean(key: String) : Boolean {
        return sharedPref.getBoolean(key, false)
    }

    fun clear(){
        editor.clear().apply()
//        editor.remove(PREF_IS_LOGIN)
//        editor.remove(PREF_USERNAME)
//        editor.remove(PREF_EMAIL)
//        editor.remove(PREF_PASSWORD)
//        editor.remove(PREF_NUMBER)
    }

}