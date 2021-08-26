package com.platform6ix.platform6ix.fragments.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.platform6ix.platform6ix.R

/**
 * Created by Das on 2021-08-25.
 */

class NotificationsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_notifications, container, false)

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        textView.text = "This is the Notifications fragment"

        /* TODO-FIXME-DEBUG
        val btnLogout: Button = root.findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            activity?.finish()
        }
         */
        return root
    }

}