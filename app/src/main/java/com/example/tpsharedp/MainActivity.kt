package com.example.tpsharedp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import android.widget.*

class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputName=findViewById<EditText>(R.id.name)
        val inputPass=findViewById<EditText>(R.id.pass)
        val btn = findViewById<Button>(R.id.btn)
        val check =findViewById<CheckBox>(R.id.checkbox)
        val sharedPreference:SharedPreference =SharedPreference(this)

        if (sharedPreference.getValueBoolien("remember",true) ) {
            inputName.text = Editable.Factory.getInstance()
                .newEditable(sharedPreference.getValueString("name"))
            inputPass.text = Editable.Factory.getInstance()
                .newEditable(sharedPreference.getValueString("pass"))
        btn.setOnClickListener {
            val name=inputName.text.toString()
            val pass=inputPass.text.toString()
           /* sharedPreference.save("name",name)
            sharedPreference.save("pass",pass)
            Toast.makeText(this@MainActivity,sharedPreference.getValueString("name")+" "+sharedPreference.getValueString("pass"),Toast.LENGTH_LONG).show()*/

                if (check.isChecked) {
                    sharedPreference.save("name", name)
                    sharedPreference.save("pass", pass)
                    sharedPreference.save("check", true)
                    Toast.makeText(this, "saved", Toast.LENGTH_LONG).show()
                }
            }}
           else{
                sharedPreference.clearSharedPreference()
            }
         }}



