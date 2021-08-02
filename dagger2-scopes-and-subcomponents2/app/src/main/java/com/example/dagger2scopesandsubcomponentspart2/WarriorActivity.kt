package com.example.dagger2scopesandsubcomponentspart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.inject.Inject

class WarriorActivity : AppCompatActivity() {

    private val TAG = "WarriorActivity"

    @Inject
    lateinit var presenter: WarriorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val appComponent = DaggerAppComponent.builder()
//            .appModule(AppModule())
//            .build()
//        val warriorScreenComponent = DaggerWarriorScreenComponent.builder()
//            .appComponent(appComponent)
//            .build()
//        warriorScreenComponent.inject(this)
//        Log.d(TAG, presenter.warrior.name)

        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()

        val warriorScreenComponent = appComponent.warriorScreenComponent(WarriorScreenModule())
        warriorScreenComponent.inject(this)
        Log.d(TAG, presenter.warrior.name)
    }
}