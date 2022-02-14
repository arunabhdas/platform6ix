package com.platform6ix.platform6ix.fragments.current

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.platform6ix.platform6ix.R
import com.platform6ix.platform6ix.network.ConnectivityInterceptorImpl
import com.platform6ix.platform6ix.services.CurrentWeatherDataSourceImpl
import com.platform6ix.platform6ix.services.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentFragment()
    }

    private lateinit var viewModel: CurrentViewModel
    private lateinit var textViewCondition: TextView
    private lateinit var imageViewConditionIcon: ImageView
    private lateinit var textViewTemperature: TextView
    private lateinit var textViewFeelsLikeTemperature: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_current, container, false)
        textViewCondition = root.findViewById(R.id.textView_condition)
        imageViewConditionIcon = root.findViewById(R.id.imageView_condition_icon)
        textViewTemperature = root.findViewById(R.id.textView_temperature)
        textViewFeelsLikeTemperature = root.findViewById(R.id.textView_feels_like_temperature)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrentViewModel::class.java)
        // TODO: Use the ViewModel
        val apiService = WeatherService(ConnectivityInterceptorImpl(this.requireContext()))

        val currentWeatherDataSource = CurrentWeatherDataSourceImpl(apiService)

        currentWeatherDataSource.downloadedCurrentWeather.observe(viewLifecycleOwner, Observer { weather ->
            textViewCondition.text = weather.currentWeatherEntry.weatherDescriptions.joinToString(separator = ",")
            textViewTemperature.text = weather.currentWeatherEntry.temperature.toString()
            textViewFeelsLikeTemperature.text = weather.location.name.toString()

            Glide
                .with(this)
                .load(weather.currentWeatherEntry.weatherIcons.first())
                .centerCrop()
                .placeholder(R.drawable.ic_weather_sunny)
                .into(imageViewConditionIcon);

        })



        GlobalScope.launch(Dispatchers.Main) {
            currentWeatherDataSource.fetchCurrentWeather("San Francisco", "en")
        }
    }

}