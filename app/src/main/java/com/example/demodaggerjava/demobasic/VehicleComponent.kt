package com.example.demodaggerjava.demobasic

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [VehicleModule::class])
interface VehicleComponent {
    fun provideVehicle(): Vehicle
}
