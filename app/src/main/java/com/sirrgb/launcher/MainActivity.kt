package com.sirrgb.launcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		calculateFibonacci()
	}

	fun calculateFibonacci() {
		var fibonacci = 1
		var startwert = 0
		var nachfolger = 1
		var i = 0
		while(i < 10) {
			System.out.println(fibonacci)
			fibonacci = startwert + nachfolger
			startwert = nachfolger
			nachfolger = fibonacci
			i++
		}
	}
}