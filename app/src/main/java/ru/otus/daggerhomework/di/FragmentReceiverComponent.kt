package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ReceiverFragment

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    @Component.Factory
    interface FragmentReceiverFactory {
        fun create(component: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragment: ReceiverFragment)
}