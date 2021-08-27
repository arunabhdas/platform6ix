package com.platform6ix.platform6ix.fragments.current

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.platform6ix.platform6ix.R
import com.platform6ix.platform6ix.services.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentFragment()
    }

    private lateinit var viewModel: CurrentViewModel
    private lateinit var textViewHome: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_current, container, false)
        textViewHome = root.findViewById(R.id.textViewHome)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrentViewModel::class.java)
        // TODO: Use the ViewModel
        val apiService = WeatherService()

        GlobalScope.launch(Dispatchers.Main) {
            val currentWeatherResponse = apiService.getCurrentWeather("Miami", "en").await()
            textViewHome.text = currentWeatherResponse.currentWeatherEntry.toString()
        }
    }

}