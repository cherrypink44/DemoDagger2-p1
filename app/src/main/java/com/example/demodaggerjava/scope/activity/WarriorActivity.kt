package com.example.demodaggerjava.scope.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.demodaggerjava.R
import com.example.demodaggerjava.scope.application.AppModule
import com.example.demodaggerjava.scope.application.DaggerAppComponent
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_warrior.*

class WarriorActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: WarriorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warrior)

        val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
        val warriorScreenComponent = DaggerWarriorScreenComponent.builder()
                .appComponent(appComponent)
                .build()
        warriorScreenComponent.inject(this)
        txtLogWarriorActivityScope.text = presenter.warrior.name
    }
}