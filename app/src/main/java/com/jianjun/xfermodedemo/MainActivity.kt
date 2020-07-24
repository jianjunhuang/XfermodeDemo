package com.jianjun.xfermodedemo

import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val xfermodeView = findViewById<XfermodeView>(R.id.xfermodeView)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            xfermodeView.setXfermode(PorterDuff.Mode.values()[checkedId])
        }

        //create view
        for (model in PorterDuff.Mode.values()) {
            val radioButton = RadioButton(this)
            radioButton.text = model.name
            radioButton.id = model.ordinal
            radioGroup.addView(radioButton)
        }
    }
}