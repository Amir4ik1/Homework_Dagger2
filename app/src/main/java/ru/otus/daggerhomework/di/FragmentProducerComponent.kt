package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ProducerFragment

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ColorGeneratorModule::class]
)
interface FragmentProducerComponent {
    @Component.Factory
    interface FragmentProducerFactory {
        fun create(component: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragment: ProducerFragment)

}

@Module
interface ColorGeneratorModule {
    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}