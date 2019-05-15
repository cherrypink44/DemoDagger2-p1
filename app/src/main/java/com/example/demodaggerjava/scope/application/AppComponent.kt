package com.example.demodaggerjava.scope.application

import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getWarrior(): Warrior
}