package com.example.taskmanager.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(private val context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun setOnBoardingSeen(isSeen: Boolean){
        pref.edit().putBoolean(ON_BOARDING_SEEN, isSeen).apply()
    }
    fun isOnBoardingSeen(): Boolean{
        return pref.getBoolean(ON_BOARDING_SEEN, false)
    }
    fun saveName(name: String){
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun getName() :String{
        return pref.getString(NAME_KEY, "").toString()

    }
    fun saveAge(age: String){
        pref.edit().putString(AGE_KEY,age).apply()
    }
    fun getAge(): String {
        return pref.getString(AGE_KEY, "").toString()
    }
    fun saveGen(gender : String){
        pref.edit().putString(GENDER_KEY, gender).apply()
    }
    fun getGen():String{
        return pref.getString(GENDER_KEY, "").toString()
    }
    fun saveImage(image: String){
        pref.edit().putString(IMAGE_KEY, image).apply()
    }
    fun getImage() :String{
        return pref.getString(IMAGE_KEY, "").toString()
    }

    companion object{
        private const val GENDER_KEY = "gender.pref"
        private const val AGE_KEY = "age.pref"
        private const val NAME_KEY = "name.pref"
        private const val IMAGE_KEY = "image.pref"
        private const val PREF_NAME = "pref_task_manager"
        private const val ON_BOARDING_SEEN = "is_seen"
    }
}
