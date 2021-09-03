package com.sirrgb.launcher

import android.content.ComponentName
import android.content.Intent
import android.graphics.drawable.Drawable

class LauncherEntry(var label: CharSequence,val icon: Drawable,var componentName: ComponentName) {
	val start = Intent(Intent.ACTION_MAIN)

	init {
		start.component = componentName
	}
	val name = label
}