package com.example.demodaggerjava.demobasic

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class VehicleModule {

    @Provides
    @Singleton
    internal fun provideMotor(): Motor {
        return Motor()
    }

    @Provides
    @Singleton
    internal fun provideVehicle(): Vehicle {
        return Vehicle(Motor())
    }
}
