package com.kianclub.kianemoji

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer

object KianVoice {

    fun isAvailable(context: Context): Boolean {
        return SpeechRecognizer.isRecognitionAvailable(context)
    }

    fun createIntent(): Intent {
        return Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE,
                "fa-IR"
            )
            putExtra(
                RecognizerIntent.EXTRA_PROMPT,
                "Speak in Persian"
            )
            putExtra(
                RecognizerIntent.EXTRA_MAX_RESULTS,
                3
            )
        }
    }
}
