package com.example.androidcomponent

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService: Service() {
    var player: MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this,Settings.System.DEFAULT_ALARM_ALERT_URI)
        player?.setLooping(true)
        player?.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}