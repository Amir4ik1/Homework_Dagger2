package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.HomeworkObserver
import ru.otus.daggerhomework.MainActivity
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {
    @Component.Factory
    interface ActivityComponentFactory {
        fun create(
            appComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun provideObserver(): HomeworkObserver

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context
}

@Qualifier
annotation class ActivityContext

@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope
