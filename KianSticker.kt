package com.kianclub.kianemoji

data class KianSticker(
    val id: String,
    val emoji: String,
    val title: String,
    val assetName: String? = null
)

object KianStickerSuggestions {

    private val stickers = mapOf(
        KianEmotion.HAPPY to listOf(
            KianSticker("happy_dog", "🐶", "سگ خوشحال"),
            KianSticker("happy_party", "🥳", "جشن و شادی")
        ),

        KianEmotion.SAD to listOf(
            KianSticker("comfort_dog", "🐕", "همدلی و آرامش"),
            KianSticker("comfort_heart", "❤️", "محبت و دلگرمی")
        ),

        KianEmotion.ANGRY to listOf(
            KianSticker("calm_dog", "🐾", "آرامش"),
            KianSticker("calm_heart", "💙", "آرام کردن")
        ),

        KianEmotion.LOVE to listOf(
            KianSticker("love_dog", "🐶❤️", "محبت"),
            KianSticker("love_heart", "💕", "عشق و علاقه")
        ),

        KianEmotion.THANKFUL to listOf(
            KianSticker("thanks_paw", "🐾🙏", "قدردانی"),
            KianSticker("thanks_heart", "❤️", "تشکر")
        ),

        KianEmotion.NEUTRAL to listOf(
            KianSticker("kian_dog", "🐶", "KIAN CLUB"),
            KianSticker("kian_paw", "🐾", "پنجه کیان")
        )
    )

    fun suggest(text: String): List<KianSticker> {
        val analysis = KianMeaning.analyze(text)
        return stickers[analysis.emotion].orEmpty()
    }
}
