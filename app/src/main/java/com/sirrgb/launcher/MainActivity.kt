package com.sirrgb.launcher

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

	var finalFibonacci = -1
	var listOfFibonacci = arrayListOf<Int>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val sharedFibonacci = getPreferences(Context.MODE_PRIVATE)
		val existString = getString(R.string.biggestFibonacciNum)
		val maxCount = 15

		println("Contains ${sharedFibonacci.contains(existString)} && getInt ${sharedFibonacci.getInt(getString(R.string.maxCount), -1)}")

		if (sharedFibonacci.contains(existString) && sharedFibonacci.getInt(getString(R.string.maxCount), -1) == maxCount) {
			println("String exists :thumbsup:")


		} else {
			println("Can't find the value, let's do some calculation")
			calculateFibonacci(maxCount)
		}
		val startButton = findViewById<Button>(R.id.start)
		startButton.setOnClickListener() {
			goTo()
		}
	}

	fun calculateFibonacci(maxCount: Int) {
		var fibonacci = 1
		var startwert = 0
		var nachfolger = 1
		var i = 0			// Counting variable
		listOfFibonacci = arrayListOf(startwert, fibonacci)

		while(i < maxCount) {
			fibonacci = startwert + nachfolger
			startwert = nachfolger
			nachfolger = fibonacci
			listOfFibonacci.add(fibonacci)
			finalFibonacci = fibonacci
			System.out.println(listOfFibonacci)
			i++
		}

		shareFibonacci(maxCount)
	}

	fun shareFibonacci(maxCount: Int) {
		val sharedFibonacci = getPreferences(Context.MODE_PRIVATE)
		with (sharedFibonacci.edit()){
			putInt(getString(R.string.biggestFibonacciNum),finalFibonacci)
			putInt(getString(R.string.maxCount), maxCount)
			apply()
		}
	}

	private fun goTo() {
		val intent = Intent(this,EngineerActivity::class.java).apply {
			//intent.putExtra("MESSAGE",finalFibonacci)

		}
		intent.putExtra("test",finalFibonacci.toString())
		intent.putIntegerArrayListExtra("ALL_THE_FIBONACCIS",listOfFibonacci)
		startActivity(intent)
	}
	fun saveArrayList(list: ArrayList<String?>?, key: String?) {
		val prefs = getPreferences(Context.MODE_PRIVATE)
		val editor = prefs.edit()
		val gson = Gson()
		val json: String = gson.toJson(list)
		editor.putString(key, json)
		editor.apply()
	}

	fun getArrayList(key: String?): ArrayList<String?>? {
		val prefs = getPreferences(Context.MODE_PRIVATE)
		val gson = Gson()
		val json = prefs.getString(key, null)
		val type= object : TypeToken<ArrayList<String?>?>() {}.type
		return gson.fromJson
	}
}