package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component(modules = [])
interface ApplicationComponent {
    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }

    @ApplicationContext
    fun applicationContext(): Context
}

@Qualifier
annotation class ApplicationContext