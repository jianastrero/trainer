package dev.jianastrero.trainer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import dev.jianastrero.trainer.data.converter.Converters
import dev.jianastrero.trainer.data.datastore.PokemonCardDataStore
import dev.jianastrero.trainer.data.datastore.PokemonDataStore
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.entity.PokemonCard
import dev.jianastrero.trainer.platform.KMPContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [
        Pokemon::class,
        PokemonCard::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class TrainerDatabase : RoomDatabase() {
    abstract fun pokemonDataStore(): PokemonDataStore
    abstract fun pokemonCardDataStore(): PokemonCardDataStore
}

// The Room compiler generates the `actual` implementations
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object TrainerDatabaseConstructor : RoomDatabaseConstructor<TrainerDatabase> {
    override fun initialize(): TrainerDatabase
}

expect fun getDatabaseBuilder(context: KMPContext): RoomDatabase.Builder<TrainerDatabase>

fun getTrainerDatabase(context: KMPContext): TrainerDatabase {
    return getDatabaseBuilder(context)
        .addMigrations()
        .fallbackToDestructiveMigration(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
