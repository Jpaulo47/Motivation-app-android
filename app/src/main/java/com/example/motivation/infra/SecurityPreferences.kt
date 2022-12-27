package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences (context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    //Salvando chave
    fun storeString(Key: String, str: String){
        security.edit().putString(Key, str).apply()

    }

    //Recuperando chave
    fun getString(Key: String): String{
        return security.getString(Key, "") ?: ""
    }
}