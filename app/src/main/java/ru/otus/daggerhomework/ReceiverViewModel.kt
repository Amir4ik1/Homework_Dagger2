package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ReceiverViewModel @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val homeworkObserver: HomeworkObserver
) {

    private val _colorState = MutableStateFlow(0)
    val colorState get() = _colorState.asStateFlow()

    suspend fun observeColors() {
        if (context !is Application) throw RuntimeException("Application context is required")
        homeworkObserver.observe().collect {
            Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            _colorState.value = it
        }
    }
}