package com.example.theme_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.CheckBox
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    lateinit var repairPartsCost: EditText
    lateinit var workingHours: EditText
    lateinit var hourCost: EditText
    lateinit var isDifficult: CheckBox
    lateinit var calculateButton: Button
    lateinit var clearButton: ImageButton
    lateinit var textViewCost: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCost = findViewById(R.id.textViewCost)
        repairPartsCost = findViewById(R.id.repairPartsCost)
        workingHours = findViewById(R.id.workingHours)
        hourCost = findViewById(R.id.hourCost)
        isDifficult = findViewById(R.id.isDifficultCheckBox)
        calculateButton = findViewById(R.id.calculateButton)
        clearButton = findViewById(R.id.clearButton)
        var repairCost = 0

        calculateButton.setOnClickListener {
            repairCost = if (isDifficult.isChecked) {
                (repairPartsCost.text.toString().toInt() + workingHours.text.toString().toInt()
                        * hourCost.text.toString().toInt()) * 2
            } else {
                repairPartsCost.text.toString().toInt() + workingHours.text.toString().toInt() *
                        hourCost.text.toString().toInt()
            }
            textViewCost.text = repairCost.toString()
        }
        clearButton.setOnClickListener{
            repairPartsCost.getText().clear()
            workingHours.getText().clear()
            hourCost.getText().clear()
            textViewCost.text = "0"
        }
    }
}
