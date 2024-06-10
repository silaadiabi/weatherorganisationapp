package com.example.weatherorganisationapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var dailyTemperatures: Array<Int>
    lateinit var weeklyAverageEditText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize daily temperatures array with default values
        dailyTemperatures = Array(7) { 0 }

        // EditText for weekly average temperature
       var weeklyAverageEditText = findViewById<EditText>(R.id.weeklyAverageEditText)

        // Button to navigate to detailed daily views
        val detailedViewBtn: Button = findViewById<Button>(R.id.detailedViewBtn)
        detailedViewBtn.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putExtra("dailyTemperatures", dailyTemperatures)
            startActivity(intent)
        }

        // Button to exit the app
        val exitBtn: Button = findViewById<Button>(R.id.exitBtn)
        exitBtn.setOnClickListener {
            finish()
        }

        // Button to clear and re-input data
        val clearBtn: Button = findViewById<Button>(R.id.exitBtn)
        clearBtn.setOnClickListener {
            clearData()
        }

        // Button to calculate and display weekly average temperature
        val calculateBtn: Button = findViewById<Button>(R.id.calculateBtn)
        calculateBtn.setOnClickListener {
            calculateWeeklyAverage()
        }
    }

    // Function to clear input data
    private fun clearData() {
        // Clear daily temperatures array
        dailyTemperatures = Array(7) { 0 }

        // Clear EditText
        weeklyAverageEditText.text.clear()
    }

    // Function to calculate and display weekly average temperature
    private fun calculateWeeklyAverage() {
        var totalTemperature = 0

        // Sum up daily temperatures
        for (temperature in dailyTemperatures) {
            totalTemperature += temperature
        }

        // Calculate average
        val averageTemperature = totalTemperature / dailyTemperatures.size

        // Display average in EditText
        weeklyAverageEditText.setText(averageTemperature.toString())
    }

    // Function to update daily temperatures array
    fun updateDailyTemperature(view: View) {
        val dayIndex = when (view.id) {
            R.id.day1Button -> 0
            R.id.day2Button -> 1
            R.id.day3Button -> 2
            R.id.day4Button -> 3
            R.id.day5Button -> 4
            R.id.day6Button -> 5
            R.id.day7Button -> 6
            else -> -1 // Invalid view
        }

        if (dayIndex != -1) {
            // Retrieve temperature from EditText
            val temperatureEditText: EditText = findViewById<EditText>(R.id.temperatureEditText)
            val temperature = temperatureEditText.text.toString().toInt()

            // Update daily temperature in array
            dailyTemperatures[dayIndex] = temperature
        }
    }
}

// Dummy data for weekly weather conditions
        val weeklyWeather = arrayOf(
            "Monday: Sunny",
            "Tuesday: Sunny",
            "Wednesday: Rainy",
            "Thursday: Partly Cloudy",
            "Friday: Stormy",
            "Saturday: Raining",
            "Sunday: Cold"
        )

    var StartedBtn =findViewById<Button>(R.id.StartedBtn)
    var NextBtn = findViewById<Button>(R.id.NextBtn)
    






