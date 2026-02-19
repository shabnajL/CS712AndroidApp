package com.example.cs712androidapp

import android.app.Service
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MyForegroundService : Service() {

    //private val CHANNEL_ID = "service_channel"

    override fun onCreate(){
        super.onCreate()
        createNotificationChannel()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification: Notification = NotificationCompat.Builder(this, "service_channel")
            .setContentTitle("CS712AndroidApp")
            .setContentText("The service has started!!")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()

        startForeground(1, notification)

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val serviceChannel = NotificationChannel( "service_channel", "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT)

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}