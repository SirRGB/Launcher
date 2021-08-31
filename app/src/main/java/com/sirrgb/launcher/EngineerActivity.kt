package com.sirrgb.launcher

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.ListView

class EngineerActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_engineer)
		//MESSAGE getIntent().getStringExtra("key")
		//var extras = intent.getIntExtra()
		var globalinput = intent.getStringExtra("test")
		System.out.println(globalinput)

        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            globalinput, "Rohit Sharma", "Steve Smith",
            "Kane Williamson", "Ross Taylor"
        )
        var mListView = findViewById<ListView>(R.id.listView)
		arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
		mListView.adapter = arrayAdapter
	}
}