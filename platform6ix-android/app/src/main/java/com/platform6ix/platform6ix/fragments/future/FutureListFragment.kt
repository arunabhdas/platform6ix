package com.platform6ix.platform6ix.fragments.future

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.platform6ix.platform6ix.R

class FutureListFragment : Fragment() {

    companion object {
        fun newInstance() = FutureListFragment()
    }

    private lateinit var viewModel: FutureListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_future_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FutureListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}