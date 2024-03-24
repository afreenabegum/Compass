package com.example.compass

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), SensorEventListener {
    // Creating variables of sensor and SensorManager

    var sensor : Sensor ?= null
    var sensorManager: SensorManager ?= null
    lateinit var imageCompass : ImageView
    lateinit var textRotationDegree : TextView
    var currentDegree = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets

            //Initializing values

            sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
            sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ORIENTATION)

            imageCompass = findViewById<ImageView>(R.id.imageCompass)
            textRotationDegree = findViewById<TextView>(R.id.textView)
        }


    override fun onSensorChanged(event: SensorEvent?) {

        val degree = Math.round(event!!.values[0])
        textRotationDegree.text = degree.toString() + " degree "

        var rangeOfRotation = RotateAnimation(currentDegree,(-degree).toFloat() ,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5F)

        rangeOfRotation.duration = 200
        rangeOfRotation.fillAfter = true

        imageCompass.startAnimation(rangeOfRotation)
        currentDegree = (-degree).toFloat()

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    //Resgister a sensor listener in the onResume()
    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    //If activity is paused, unregister so that memory, battery, space will not be wasted
    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
}