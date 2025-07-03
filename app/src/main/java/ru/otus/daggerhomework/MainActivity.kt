package ru.otus.daggerhomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityComponent: MainActivityComponent

    @Inject
    lateinit var homeworkObserver: HomeworkObserver

    fun getMainActivityComponent(): MainActivityComponent = mainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            (application as App).applicationComponent,
            this
        )
        mainActivityComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}