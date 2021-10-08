package com.example.examplefragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

class MenuExample : AppCompatActivity() {
	//
	// 안드로이드 4.1 이후로는 전역변수를 지향하는 편
	//

	lateinit var button3: Button
	lateinit var editTxt3: EditText
	lateinit var image3: ImageView

	lateinit var button4: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.menuexample)

		//
		// initalize
		//

		val text1: TextView = findViewById(R.id.menuTextView1)
		val btn1: Button = findViewById(R.id.menuButton1)
		button3 = findViewById<Button>(R.id.menuButton3)
		editTxt3 = findViewById<EditText>(R.id.menuEditText3)
		image3 = findViewById<MyImage>(R.id.menuImageView3)
		button4 = findViewById<Button>(R.id.menuButton4)

		registerForContextMenu(button3)
		registerForContextMenu(editTxt3)
		registerForContextMenu(image3)

		//
		// button 1 onClick
		//

		btn1.setOnClickListener{
			val textViewString : String = text1.text.toString()

			if(textViewString == "Hello World!")
				text1.text = "Bye World!"
			else
				text1.text = "Hello World!"
		}

		//
		// textView1 onClick
		//

		val mClickLintener : View.OnClickListener = object : View.OnClickListener{
			override fun onClick(v: View?) {

				//
				// show Toast
				//

				if(v?.id == R.id.menuTextView1) {
					val text1 = when(text1.text){
						"Hello World!" -> "Hello"
						"Bye World!" -> "Bye"
						else -> "empty"
					}

					Toast.makeText(applicationContext, text1, Toast.LENGTH_SHORT).show()
				}
			}
		}

		text1.setOnClickListener(mClickLintener)

		Toast.makeText(this, intent.getStringExtra("ContentAlart"), Toast.LENGTH_SHORT).show()
	}

	public fun mOnClick(v:View){
		val text2 = findViewById<TextView>(R.id.menuTextView2)

		when(v.id){
			R.id.menuButton2 ->
				if (text2.text == "Hello2")
					text2.setText("Bye2")
				else
					text2.setText("Hello2")
		}
	}

	//
	// contextMenu
	//

	public override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?){
		super.onCreateContextMenu(menu, v, menuInfo)

		if (v == button3){
			menu.setHeaderTitle("Button Menu")
			menu.addSubMenu(0,1,0,"red")
			menu.addSubMenu(0,2,0,"green")
			menu.addSubMenu(0,3,0,"blue")
		}

		if (v == editTxt3) {
			menu.add(0,4,0,"번역하기")
			menu.add(0,5,0,"필기인식")
		}
	}

	public override fun onContextItemSelected(item: MenuItem) : Boolean{
		if(item.itemId == 1){
			button3.setTextColor(Color.RED)
			return  true
		}
		else if (item.itemId == 2){
			button3.setTextColor(Color.GREEN)
			return  true
		}
		else if (item.itemId == 3){
			button3.setTextColor(Color.BLUE)
			return  true
		}
		else if (item.itemId == 4){
			Toast.makeText(this, "번역", Toast.LENGTH_SHORT).show()
			return  true
		}
		else if (item.itemId == 5){
			Toast.makeText(this, "필기인식", Toast.LENGTH_SHORT).show()
			return  true
		}
		else if (item.itemId == 100){
			Toast.makeText(this, "회전", Toast.LENGTH_SHORT).show()
			return  true
		}
		else if (item.itemId == 101) {
			Toast.makeText(this, "크기변경", Toast.LENGTH_SHORT).show()
			return  true
		}

		return false
	}

	//
	// popup 메뉴
	//

	public fun popupMenuOnClick(v: View){

		val popup:PopupMenu = PopupMenu(this, v)
		val inflater: MenuInflater = popup.menuInflater
		val menu = popup.menu

		inflater.inflate(R.menu.popupmenutestmenu, menu)

		popup.setOnMenuItemClickListener{ item ->
			when (item.itemId){
				R.id.popup_red -> button4.setBackgroundColor(Color.RED)
				R.id.popup_blue -> button4.setBackgroundColor(Color.BLUE)
				R.id.popup_green -> button4.setBackgroundColor(Color.GREEN)
				R.id.popup_black -> button4.setTextColor(Color.BLACK)
				R.id.popup_white -> button4.setTextColor(Color.WHITE)
				R.id.popup_gray -> button4.setTextColor(Color.GRAY)
			}

			false
		}

		popup.show()
	}
}