package com.example.demodaggerjava.scope.activity

import com.example.demodaggerjava.scope.application.AppComponent
import dagger.Component

@WarriorScreenScope
@Component(modules = [WarriorScreenModule::class],
        dependencies = [AppComponent::class])
interface WarriorScreenComponent {
    fun inject(warriorActivity: WarriorActivity)
}