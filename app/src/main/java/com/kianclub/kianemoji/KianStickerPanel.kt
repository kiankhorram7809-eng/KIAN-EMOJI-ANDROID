package com.kianclub.kianemoji

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout

class KianStickerPanel(context: Context) {

    private val panel = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER
        setPadding(4, 8, 4, 8)
        setBackgroundColor(Color.rgb(245, 245, 245))
    }

    fun getView(): LinearLayout {
        return panel
    }

    fun showSuggestions(
        text: String,
        onStickerSelected: (KianSticker) -> Unit
    ) {
        panel.removeAllViews()

        val suggestions = KianStickerSuggestions.suggest(text)

        suggestions.forEach { sticker ->
            val button = Button(panel.context).apply {
                this.text = sticker.emoji
                textSize = 22f
                isAllCaps = false
                setOnClickListener {
                    onStickerSelected(sticker)
                }
            }

            panel.addView(
                button,
                LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
                )
            )
        }
    }
}
