package com.example.currency_exchange

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rial = findViewById<EditText>(R.id.rial_text)
        val us_dollar = findViewById<EditText>(R.id.usdollar_text)
        val canada_dollar = findViewById<EditText>(R.id.canadadollar_text)
        val pound = findViewById<EditText>(R.id.pound_text)
        val euro = findViewById<EditText>(R.id.euro_text)
        val dirham = findViewById<EditText>(R.id.derham_text)


        rial.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
              if (rial.hasFocus()) {
                  if(s.toString().toDoubleOrNull() == null) {
                        return
                  }
                  us_dollar.setText(((s.toString().toDouble())*0.0000024).toString())
                  canada_dollar.setText(((s.toString().toDouble())*0.0000032).toString())
                  pound.setText(((s.toString().toDouble())*0.0000019).toString())
                  euro.setText(((s.toString().toDouble())*0.0000023).toString())
                  dirham.setText(((s.toString().toDouble())*0.0000087).toString())
                }
            }
        })

        us_dollar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (us_dollar.hasFocus()) {
                    if(s.toString().toDoubleOrNull() == null) {
                        return
                    }
                    rial.setText(((s.toString().toDouble())/0.0000024).toString())
                    canada_dollar.setText(((s.toString().toDouble())*1.36).toString())
                    pound.setText(((s.toString().toDouble())*0.83).toString())
                    euro.setText(((s.toString().toDouble())*0.94).toString())
                    dirham.setText(((s.toString().toDouble())*3.67).toString())
                }
            }
        })

        canada_dollar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (canada_dollar.hasFocus()) {
                    if(s.toString().toDoubleOrNull() == null) {
                        return
                    }
                    rial.setText(((s.toString().toDouble())*31524).toString())
                    us_dollar.setText(((s.toString().toDouble())*0.74).toString())
                    pound.setText(((s.toString().toDouble())*0.61).toString())
                    euro.setText(((s.toString().toDouble())*0.71).toString())
                    dirham.setText(((s.toString().toDouble())*2.73).toString())
                }
            }
        })

        pound.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (pound.hasFocus()) {
                    if(s.toString().toDoubleOrNull() == null) {
                        return
                    }
                    rial.setText(((s.toString().toDouble())*51916).toString())
                    us_dollar.setText(((s.toString().toDouble())*1.23).toString())
                    canada_dollar.setText(((s.toString().toDouble())*1.65).toString())
                    euro.setText(((s.toString().toDouble())*1.16).toString())
                    dirham.setText(((s.toString().toDouble())*4.5).toString())
                }
            }
        })

        euro.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (euro.hasFocus()) {
                    if(s.toString().toDoubleOrNull() == null) {
                        return
                    }
                    rial.setText(((s.toString().toDouble())*445900).toString())
                    us_dollar.setText(((s.toString().toDouble())*1.05).toString())
                    canada_dollar.setText(((s.toString().toDouble())*1.14).toString())
                    pound.setText(((s.toString().toDouble())*0.86).toString())
                    dirham.setText(((s.toString().toDouble())*3.87).toString())
                }
            }
        })

        dirham.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (dirham.hasFocus()) {
                    if(s.toString().toDoubleOrNull() == null) {
                        return
                    }
                    rial.setText(((s.toString().toDouble())*11366).toString())
                    us_dollar.setText(((s.toString().toDouble())*0.27).toString())
                    canada_dollar.setText(((s.toString().toDouble())*0.37).toString())
                    pound.setText(((s.toString().toDouble())*0.23).toString())
                    euro.setText(((s.toString().toDouble())*0.26).toString())
                }
            }
        })
    }
}