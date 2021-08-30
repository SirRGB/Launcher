package com.sirrgb.launcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		calculateFibonacci(5)
	}

	fun calculateFibonacci(maxCount: Int) {
		var fibonacci = 1
		var startwert = 0
		var nachfolger = 1
		var i = 0
		var listOfFibonacci = arrayListOf(fibonacci)

		while(i < maxCount) {
			listOfFibonacci.add(fibonacci)
			System.out.println(listOfFibonacci)
			fibonacci = startwert + nachfolger
			startwert = nachfolger
			nachfolger = fibonacci
			i++
		}
	}
}