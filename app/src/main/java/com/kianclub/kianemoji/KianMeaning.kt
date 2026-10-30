package com.kianclub.kianemoji

enum class KianEmotion {
    HAPPY,
    SAD,
    ANGRY,
    LOVE,
    THANKFUL,
    NEUTRAL
}

data class KianAnalysis(
    val emotion: KianEmotion,
    val sticker: String,
    val meaning: String
)

object KianMeaning {

    fun analyze(text: String): KianAnalysis {
        val message = text.trim().lowercase()

        return when {
            containsAny(message, listOf("دوستت دارم", "عاشقتم", "عزیزم")) ->
                KianAnalysis(
                    KianEmotion.LOVE,
                    "❤️",
                    "پیام محبت‌آمیز"
                )

            containsAny(message, listOf("خوشحالم", "عالیه", "آفرین", "هورا")) ->
                KianAnalysis(
                    KianEmotion.HAPPY,
                    "🥳",
                    "پیام شاد و مثبت"
                )

            containsAny(message, listOf("ناراحتم", "دلم گرفته", "غمگینم")) ->
                KianAnalysis(
                    KianEmotion.SAD,
                    "🥺",
                    "پیام ناراحتی"
                )

            containsAny(message, listOf("عصبانی", "حرصم", "اعصابم")) ->
                KianAnalysis(
                    KianEmotion.ANGRY,
                    "😠",
                    "پیام عصبانیت"
                )

            containsAny(message, listOf("ممنون", "متشکرم", "سپاس")) ->
                KianAnalysis(
                    KianEmotion.THANKFUL,
                    "🙏",
                    "پیام قدردانی"
                )

            else ->
                KianAnalysis(
                    KianEmotion.NEUTRAL,
                    "🐶",
                    "پیام عادی"
                )
        }
    }

    private fun containsAny(
        text: String,
        words: List<String>
    ): Boolean {
        return words.any { text.contains(it) }
    }
}
