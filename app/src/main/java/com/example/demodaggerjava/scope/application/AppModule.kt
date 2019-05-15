package com.example.demodaggerjava.scope.application

import dagger.Module
import dagger.Provides

@Module
class AppModule {
    private var index = 0

    @ApplicationScope
    @Provides
    fun provideWarrior(): Warrior {
        index++
        return Warrior("Warrior $index")
    }
}