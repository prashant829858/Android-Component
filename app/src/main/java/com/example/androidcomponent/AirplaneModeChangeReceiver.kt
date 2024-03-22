package com.example.androidcomponent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver: BroadcastReceiver() {
    override fun onReceive(contaxt: Context?, intent: Intent?) {
        val status = intent?.getBooleanExtra("name",false)?: return
        if (status) {
            Toast.makeText(contaxt, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(contaxt,"Airplane Mode Disabled", Toast.LENGTH_LONG).show()
        }
    }
}