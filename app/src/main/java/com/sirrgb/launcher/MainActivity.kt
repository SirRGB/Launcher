package com.sirrgb.launcher

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

	var finalFibonacci = -1
	var listOfFibonacci = arrayListOf<Int>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		calculateFibonacci(5)
		val startButton = findViewById<Button>(R.id.start)
		startButton.setOnClickListener() {
			goTo()
		}
	}

	fun calculateFibonacci(maxCount: Int) {
		var fibonacci = 1
		var startwert = 0
		var nachfolger = 1
		var i = 0
		listOfFibonacci = arrayListOf(fibonacci)

		while(i < maxCount) {
			listOfFibonacci.add(fibonacci)
			//System.out.println(listOfFibonacci)
			fibonacci = startwert + nachfolger
			startwert = nachfolger
			nachfolger = fibonacci
			finalFibonacci = fibonacci
			i++

			//finde größte Fibonacci Zahl
		}
		//System.out.println(finalFibonacci)
	}

	private fun goTo() {
		val intent = Intent(this,EngineerActivity::class.java).apply {
			//intent.putExtra("MESSAGE",finalFibonacci)

		}
		intent.putExtra("test",finalFibonacci.toString())
		intent.putIntegerArrayListExtra("ALL_THE_FIBONACCIS",listOfFibonacci)
		startActivity(intent)
	}
}