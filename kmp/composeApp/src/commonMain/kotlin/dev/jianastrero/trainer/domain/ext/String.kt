package dev.jianastrero.trainer.domain.ext

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale

val String.capitalized: String
    get() {
        return split("\\s+".toRegex())
            .joinToString(" ") { it.capitalize(Locale.current) }
    }
