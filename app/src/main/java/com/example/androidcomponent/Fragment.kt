package com.example.androidcomponent

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class Fragment : Fragment(), View.OnClickListener {
    var btnStart : Button? = null
    var btnStop : Button? = null
    var status : Boolean = true
    private lateinit var receiver : AirplaneModeChangeReceiver

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_, container, false)

        receiver = AirplaneModeChangeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            activity?.registerReceiver(receiver, it)
        }


        btnStart = view.findViewById<Button>(R.id.btn_start)
        btnStop = view.findViewById<Button>(R.id.btn_stop)

        btnStart?.setOnClickListener(this)
        btnStop?.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View?) {
        if (view === btnStart && status){
            Toast.makeText(context, "Service Started", Toast.LENGTH_LONG).show()
            requireActivity().startService(Intent(context, MyService::class.java))
            status = false
        }
        else if (view === btnStop){
            Toast.makeText(context,"Service Stopped", Toast.LENGTH_SHORT).show()
            requireActivity().stopService(Intent(context,MyService::class.java))
            status = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().stopService(Intent(context,MyService::class.java))
    }

    override fun onStop() {
        super.onStop()
    }
}