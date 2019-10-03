package com.example.hitungbasket

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val COUNTA ="counta"
    val COUNTB ="countb"
    var counta:Int = 0
    var countb:Int = 0
    private var sharedPreference: SharedPreferences? =null
    private val sharePrefFile:String = "myPrefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreference = getSharedPreferences(sharePrefFile, Context.MODE_PRIVATE)
        counta = sharedPreference!!.getInt(COUNTA, 0)
        txt_scorea.text=counta.toString()
        countb = sharedPreference!!.getInt(COUNTB, 0)
        txt_scoreb.text=countb.toString()
        menanga.isChecked=false
        menangb.isChecked=false
        if (counta>countb){
            menanga.isChecked=true
        }else if(countb>counta){
            menangb.isChecked=true
        }
    }
    override fun onPause() {
        super.onPause()
        val preferencesEditor = sharedPreference?.edit()
        preferencesEditor?.putInt(COUNTA,counta)
        preferencesEditor?.putInt(COUNTB,countb)
        preferencesEditor?.apply()
    }
    fun tigaa (view: View){
        counta +=3
        txt_scorea.text=counta.toString()
    }
    fun tigab (view: View){
        countb +=3
        txt_scoreb.text=countb.toString()
    }
    fun duaa (view: View){
        counta +=2
        txt_scorea.text=counta.toString()
    }
    fun duab (view: View){
        countb +=2
        txt_scoreb.text=countb.toString()
    }
    fun satua (view: View){
        counta ++
        txt_scorea.text=counta.toString()
    }
    fun satub (view: View){
        countb ++
        txt_scoreb.text=countb.toString()
    }
    fun reset (view: View){
        counta=0
        countb=0
        txt_scorea.text=counta.toString()
        txt_scoreb.text=countb.toString()
        val preferencesEditor = sharedPreference?.edit()
        preferencesEditor?.clear()
        preferencesEditor?.apply()
        menanga.isChecked=false
        menangb.isChecked=false
    }
}
