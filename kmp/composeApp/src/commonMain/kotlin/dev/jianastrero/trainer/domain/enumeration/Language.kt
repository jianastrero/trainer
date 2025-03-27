package dev.jianastrero.trainer.domain.enumeration

import kotlinx.serialization.SerialName

enum class Language(val code: String) {
    @SerialName("en") English("en"),
    @SerialName("ja") Japanese("ja"),
    @SerialName("ja-Hrkt") JapaneseHiraganaKatakana("ja-Hrkt"),
    @SerialName("ko") Korean("ko"),
    @SerialName("zh-Hant") ChineseTraditional("zh-Hant"),
    @SerialName("zh-Hans") ChineseSimplified("zh-Hans"),
    @SerialName("fr") French("fr"),
    @SerialName("de") German("de"),
    @SerialName("es") Spanish("es"),
    @SerialName("it") Italian("it"),
}
