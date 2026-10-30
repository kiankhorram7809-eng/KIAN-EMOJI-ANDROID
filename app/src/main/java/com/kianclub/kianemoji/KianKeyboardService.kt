package com.kianclub.kianemoji

import android.inputmethodservice.InputMethodService
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.Gravity
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.LinearLayout

class KianKeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        val keyboard = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(4, 8, 4, 8)
            setBackgroundColor(Color.rgb(245, 245, 245))
        }

        val rows = listOf(
            listOf("ض", "ص", "ث", "ق", "ف", "غ", "ع", "ه", "خ", "ح", "ج"),
            listOf("ش", "س", "ی", "ب", "ل", "ا", "ت", "ن", "م", "ک", "گ"),
            listOf("ظ", "ط", "ز", "ر", "ذ", "د", "پ", "و")
        )

        rows.forEach { row ->
            val rowLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER
            }

            row.forEach { character ->
                rowLayout.addView(createKey(character) {
                    currentInputConnection?.commitText(character, 1)
                })
            }

            keyboard.addView(rowLayout)
        }

        val controls = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
        }

        controls.addView(createKey("حذف") {
            currentInputConnection?.deleteSurroundingText(1, 0)
        })

        controls.addView(createKey("فاصله") {
            currentInputConnection?.commitText(" ", 1)
        })

        controls.addView(createKey("↵") {
            currentInputConnection?.commitText("\n", 1)
        })

        keyboard.addView(controls)

        return keyboard
    }

    private fun createKey(
        label: String,
        action: () -> Unit
    ): Button {
        return Button(this).apply {
            text = label
            textSize = 16f
            setTextColor(Color.BLACK)
            setBackgroundColor(Color.WHITE)
            isAllCaps = false
            setOnClickListener { action() }

            layoutParams = LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            ).apply {
                setMargins(2, 3, 2, 3)
            }
        }
    }
}
