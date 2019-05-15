package com.example.demodaggerjava.scope.application

import android.app.Application
import android.util.Log

class WarriorApplication : Application() {
    private val TAG = "WarriorApplication"

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
        Log.d(TAG, appComponent.getWarrior().name)
        Log.d(TAG, appComponent.getWarrior().name)
    }
}