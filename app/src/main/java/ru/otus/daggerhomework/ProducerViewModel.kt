package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ProducerViewModel @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext
    private val context: Context,
    private val homeworkObserver: HomeworkObserver
) {

    suspend fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        homeworkObserver.send(colorGenerator.generateColor())
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}