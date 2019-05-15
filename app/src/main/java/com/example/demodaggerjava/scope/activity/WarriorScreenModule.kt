package com.example.demodaggerjava.scope.activity

import com.example.demodaggerjava.scope.application.Warrior
import dagger.Module
import dagger.Provides

@Module
class WarriorScreenModule {
    @Provides
    @WarriorScreenScope
    fun provideWarriorPresenter(warrior : Warrior): WarriorPresenter {
        return WarriorPresenter(warrior)
    }
}