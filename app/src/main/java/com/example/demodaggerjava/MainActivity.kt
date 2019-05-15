package com.example.demodaggerjava

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.example.demodaggerjava.demobasic.DaggerVehicleComponent
import com.example.demodaggerjava.demobasic.Vehicle
import com.example.demodaggerjava.demobasic.VehicleModule
import com.example.demodaggerjava.scope.activity.WarriorActivity
import kotlinx.android.synthetic.main.activity_main.*

// https://medium.com/tompee/dagger-2-scopes-and-subcomponents-d54d58511781

class MainActivity : AppCompatActivity() {
    internal lateinit var vehicle: Vehicle
    private val TAG = "WarriorApplication"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Basic Dagger
        val component = DaggerVehicleComponent.builder().vehicleModule(VehicleModule()).build()

        vehicle = component.provideVehicle()
        vehicle.increaseSpeed(5000000)
        Toast.makeText(this, vehicle.speed.toString(), Toast.LENGTH_SHORT).show()

        btnScopeActivity.setOnClickListener {
            val intent = Intent(applicationContext, WarriorActivity::class.java)
            startActivity(intent)
        }
    }
}
