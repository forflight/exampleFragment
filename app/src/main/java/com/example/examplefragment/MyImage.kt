package com.example.examplefragment

import android.content.Context
import android.util.AttributeSet
import android.view.ContextMenu
import androidx.appcompat.widget.AppCompatImageView

class MyImage @JvmOverloads constructor(
	context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

	override fun onCreateContextMenu(menu: ContextMenu) {
		super.onCreateContextMenu(menu)

		menu.setHeaderTitle("Image3 Menu")
		menu.add(0,100,0, "이미지 회전")
		menu.add(0,101,0,"크기 변경")
	}
}