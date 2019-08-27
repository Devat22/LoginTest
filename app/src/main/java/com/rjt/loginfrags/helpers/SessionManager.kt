package com.rjt.loginfrags.helpers

import android.content.Context
import android.content.SharedPreferences
import android.provider.ContactsContract

class SessionManager(context:Context) {
    private val FILE_NAME = "myFile"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"
    private val KEY_PASS = "pass"
    private val KEY_ISLOGIN = "isLogin"

    lateinit var sharedPreference:SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    init {
        this.sharedPreference = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)
        this.editor = sharedPreference.edit()
    }

    public fun login(email: String, pass:String):Boolean{
        if(!isLoggedIn()) return false
        val inEmail:String = sharedPreference.getString(KEY_EMAIL,"")
        val inPass:String = sharedPreference.getString(KEY_PASS, "")
        if(email.equals(inEmail) && pass.equals(inPass)) return true
        return false
    }

    public fun register(name:String, email: String, pass: String){
        editor.putString(KEY_NAME,name)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PASS, pass)
        editor.putBoolean(KEY_ISLOGIN,true)
        editor.commit()
    }

    public fun isLoggedIn():Boolean{
        val isLoggedIn = sharedPreference.getBoolean(KEY_ISLOGIN, false)
        if(isLoggedIn) return true
        return false
    }

    public fun logout(){
        editor.putBoolean(KEY_ISLOGIN,false)

    }

    public fun getName():String{
        return sharedPreference.getString(KEY_NAME,"")
    }

}