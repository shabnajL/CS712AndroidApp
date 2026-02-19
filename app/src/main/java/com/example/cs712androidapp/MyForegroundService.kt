package com.example.cs712androidapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyForegroundService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "The service has started!!", Toast.LENGTH_LONG).show()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
