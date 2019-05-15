package com.example.demodaggerjava.demobasic

class Motor {
    var rpm: Int = 0

    init {
        this.rpm = 0
    }

    fun accelerate(value: Int) {
        rpm = rpm + value
    }

    fun brake() {
        rpm = 0
    }
}
