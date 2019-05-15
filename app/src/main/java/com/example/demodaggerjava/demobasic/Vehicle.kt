package com.example.demodaggerjava.demobasic

import javax.inject.Inject

class Vehicle
@Inject constructor(private val motor: Motor) {

    val speed: Int
        get() = motor.rpm

    fun increaseSpeed(value: Int) {
        motor.accelerate(value)
    }

    fun stop() {
        motor.brake()
    }
}
