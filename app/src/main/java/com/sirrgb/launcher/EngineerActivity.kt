package com.sirrgb.launcher

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class EngineerActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_engineer)
		//MESSAGE getIntent().getStringExtra("key")
		//var extras = intent.getIntExtra()
		var globalinput = intent.getStringExtra("test")
		System.out.println(globalinput)
	}
}