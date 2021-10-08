package com.example.examplefragment

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class FragmentTest : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.fragmentest)

		Toast.makeText(this, intent.getStringExtra("ContentAlart"), Toast.LENGTH_SHORT).show()
	}

	//
	//
	//

	class CounterFragment: Fragment() {
		override fun onCreateView(
			inflater: LayoutInflater,
			container: ViewGroup?,
			savedInstanceState: Bundle?,
		): View? {

			val root: View = inflater.inflate(R.layout.counterfragment, container, false)

			val btnIncrease: Button = root.findViewById<Button>(R.id.btnIncrease)
			val textCounter: TextView= root.findViewById<TextView>(R.id.txtCounter)

			if (savedInstanceState != null)
				textCounter.setText(Integer.toString(savedInstanceState.getInt("counter")))

			btnIncrease.setOnClickListener{
					var count = Integer.parseInt(textCounter.text.toString())
					textCounter.setText(Integer.toString(count + 1))
			}

			return root
		}

		override fun onSaveInstanceState(outState: Bundle) {
			super.onSaveInstanceState(outState)

			val textCount: TextView = requireView().findViewById(R.id.txtCounter)
			var count: Int = Integer.parseInt(textCount.text.toString())

			outState.putInt("counter", count)
		}
	}
}