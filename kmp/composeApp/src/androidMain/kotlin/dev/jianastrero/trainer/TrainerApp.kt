package dev.jianastrero.trainer

import android.app.Application
import dev.jianastrero.trainer.di.initKoin
import org.koin.android.ext.koin.androidContext

class TrainerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        instance = this

        initKoin {
            androidContext(this@TrainerApp)
        }
    }

    companion object {
        lateinit var instance: TrainerApp
            private set
    }

}
