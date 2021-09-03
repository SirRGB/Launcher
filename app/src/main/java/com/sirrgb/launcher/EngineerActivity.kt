package com.sirrgb.launcher

import android.content.ComponentName
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.Intent.ACTION_MAIN
import android.content.Intent.CATEGORY_LAUNCHER
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.widget.ArrayAdapter
import android.widget.ListView

class EngineerActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_engineer)
		//MESSAGE getIntent().getStringExtra("key")
		//var extras = intent.getIntExtra()
		val globalinput = intent.getStringExtra("test")
		val fibonacciArray = intent.getIntegerArrayListExtra("ALL_THE_FIBONACCIS")
		val random = Math.floor(Math.random() * 42069) + 1
		var appList = getAllMainActivities()


		// Array Adapter
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayListOf(
            globalinput,
        )
		appList!!.forEach { app ->
			users.add(app.label.toString())
		}
		fibonacciArray!!.forEach { fibonacci ->
			if(fibonacci >= 2) {
				users.add(fibonacci.toString())
			}

		}
		// Array A

        var mListView = findViewById<ListView>(R.id.listView)
		arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
		mListView.adapter = arrayAdapter

		appList!!.forEach { app ->
			if (app.label.toString() == "Camera"){
				println("Start camera")
				startActivity(app.start)
			}

			if (app.label.toString() == "Settings"){
				println("Start settings")
				startActivity(app.start)
			}

		}
	}

	fun getAllMainActivities(): List<LauncherEntry> {
		val intent = Intent(ACTION_MAIN)
		intent.addCategory(CATEGORY_LAUNCHER)
		var query = packageManager.queryIntentActivities(intent, 0)

		val entries = query.map { LauncherEntry(it.loadLabel(packageManager),it.loadIcon(packageManager),
			ComponentName(it.activityInfo.packageName,it.activityInfo.name)
		) }

		println("exitst ${entries}")
		return entries
	}
}