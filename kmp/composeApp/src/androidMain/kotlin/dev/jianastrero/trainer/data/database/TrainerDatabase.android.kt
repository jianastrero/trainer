package dev.jianastrero.trainer.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import dev.jianastrero.trainer.platform.KMPContext

actual fun getDatabaseBuilder(context: KMPContext): RoomDatabase.Builder<TrainerDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("trainer.db")
    return Room.databaseBuilder<TrainerDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
