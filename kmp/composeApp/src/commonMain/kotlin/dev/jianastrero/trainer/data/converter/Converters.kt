package dev.jianastrero.trainer.data.converter

import androidx.room.TypeConverter
import dev.jianastrero.trainer.domain.enumeration.PokemonStat
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import kotlinx.serialization.json.Json
import kotlin.jvm.JvmStatic

object Converters {

    private val json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @JvmStatic
    @TypeConverter
    fun stringListToString(value: List<String>): String {
        return json.encodeToString(value)
    }

    @JvmStatic
    @TypeConverter
    fun stringToStringList(value: String): List<String> {
        return json.decodeFromString(value)
    }

    @JvmStatic
    @TypeConverter
    fun pokemonTypeListToString(value: List<PokemonType>): String {
        return json.encodeToString(value)
    }

    @JvmStatic
    @TypeConverter
    fun stringToPokemonTypeList(value: String): List<PokemonType> {
        return json.decodeFromString(value)
    }

    @JvmStatic
    @TypeConverter
    fun statMapToString(value: Map<PokemonStat, Int>): String {
        return json.encodeToString(value)
    }

    @JvmStatic
    @TypeConverter
    fun stringToStatMap(value: String): Map<PokemonStat, Int> {
        return json.decodeFromString(value)
    }
}
