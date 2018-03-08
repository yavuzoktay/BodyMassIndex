package com.example.yavuz.bodymassindex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {


    lateinit var weight :SeekBar
    lateinit var height :SeekBar
    lateinit var heightText:TextView
    lateinit var weightText:TextView
    lateinit var calculate:Button
    lateinit var result:TextView
    lateinit var resultWrite: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        weight =findViewById(R.id.weight_seekbar)
        height =findViewById(R.id.height_seekbar)
        heightText=findViewById(R.id.height)
        weightText=findViewById(R.id.weight)
        calculate=findViewById(R.id.calculate)
        result=findViewById(R.id.result)
        resultWrite=findViewById(R.id.resultWrite)

        weight .max=150

        weight .setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                weightText.text=p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })


        height .max=200

        height .setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                heightText.text=p1.toString()

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })


        calculate.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var result1:Double = 0.0
                result1=(weightText.text.toString().toDouble())/(((heightText.text.toString().toDouble()/100))*(heightText.text.toString().toDouble()/100))
                result.text=result1.toString().format(3)

                when (result1) {
                    in 0..18 -> resultWrite.text="Underweight"
                    in 19..24 -> resultWrite.text="Healthy"
                    in 25..29 -> resultWrite.text="Overweight"
                    in 30..39 -> resultWrite.text="Obese"
                    else -> { resultWrite.text="Extremely Obese"
                    }
                }
            }
        })


    }






}


