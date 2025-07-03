package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import javax.inject.Inject

class ProducerFragment : Fragment() {

    @ApplicationContext
    @Inject
    lateinit var applicationContext: Context

    @Inject
    lateinit var viewModel: ProducerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFragmentProducerComponent.factory().create(
            (requireActivity() as MainActivity).getMainActivityComponent()
        ).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_producer, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через flow в другой фрагмент
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                    viewModel.generateColor()
                }
            }
        }
    }
}