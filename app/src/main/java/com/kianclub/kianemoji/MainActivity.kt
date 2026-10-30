package com.kianclub.kianemoji

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import android.content.Context
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 48, 32, 32)
        }

        val title = TextView(this).apply {
            text = "KIAN EMOJI"
            textSize = 28f
        }

        val description = TextView(this).apply {
            text = "Persian Smart Keyboard"
            textSize = 18f
        }

        val enableButton = Button(this).apply {
            text = "Enable Keyboard"
            setOnClickListener {
                startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
            }
        }

        val selectButton = Button(this).apply {
            text = "Select Keyboard"
            setOnClickListener {
                val manager = getSystemService(
                    Context.INPUT_METHOD_SERVICE
                ) as InputMethodManager
                manager.showInputMethodPicker()
            }
        }

        layout.addView(title)
        layout.addView(description)
        layout.addView(enableButton)
        layout.addView(selectButton)

        setContentView(layout)
    }
}
