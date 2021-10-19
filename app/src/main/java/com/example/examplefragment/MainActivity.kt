package com.example.examplefragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		//
		// just branch test
		//
	}

	fun mOnClick(v: View){
		when(v.id){
			R.id.button->{
				val intent: Intent = Intent(this, FragmentTest::class.java)
				intent.putExtra("ContentAlart", "Fragment")

				startActivity(intent)
			}
			R.id.button2->{
				val intent: Intent = Intent(this, MenuExample::class.java)
				intent.putExtra("ContentAlart", "Menu")

				startActivity(intent)
			}
			R.id.button3->{
				val intent: Intent = Intent(this, CustomView::class.java)
				intent.putExtra("ContentAlart", "CustomView")

				startActivity(intent)
			}
		}
	}
}