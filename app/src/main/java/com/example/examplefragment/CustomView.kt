package com.example.examplefragment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.*
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

class CustomView : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val vm : View = MyView(this)
		setContentView(vm)

		Toast.makeText(this, intent.getStringExtra("ContentAlart"), Toast.LENGTH_SHORT).show()
	}

	//
	// customView
	//
	// extends View, inflate() has problem at ViewGroup parameter
	// so extends ConstraintLayout
	//

	class MyView @JvmOverloads constructor(
		context: Context,
		attrs: AttributeSet? = null,
		defStyleAttr: Int = 0
		// ) : View(context, attrs, defStyleAttr) {
	) : ConstraintLayout(context, attrs, defStyleAttr) {

		init {
			LayoutInflater.from(context).inflate(R.layout.customview, this, true)
		}

		override fun onTouchEvent(evt : MotionEvent) : Boolean{
			super.onTouchEvent(evt)

			var nTouchX: Int = evt.x.toInt()
			var nTouchY: Int = evt.y.toInt()

			if (evt.action == MotionEvent.ACTION_DOWN){

				val text1: TextView = findViewById(R.id.cvTextView)

				text1.setText("recent Touch X: $nTouchX, Y : $nTouchY")

				return true
			}

			return false
		}
	}
}