package com.example.taskmanager.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import com.example.taskmanager.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class PushNotificationService: FirebaseMessagingService() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val title = message.notification?.title
        val desc = message.notification?.body
        val channel = NotificationChannel(CHaNELL_ID, "Heads Up Notification", NotificationManager.IMPORTANCE_HIGH)
        //val notify =

        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)

        val notification = Notification.Builder(this, CHaNELL_ID)
            .setContentTitle(title)
            .setContentText(desc)
            .setSmallIcon(R.drawable.ic_launcher_foreground)                //это для иконки на уведомления,например уведомления инсты, вотса итд,маленькая иконка приходит,иконка приложения
            .setAutoCancel(true)                                            //это нужно для того чтобы смахивать уведомления тоесть сворачивать, но если напишем false то смахнуть будет невозможно

        NotificationManagerCompat.from(this).notify(1, notification.build())
        //Log.e("ololo", "onMessageReceived: " + message.notification?.title)     //loge нужен для отображения, пришло ли или нет
    }

    companion object {
        const val CHaNELL_ID = "TASK_ID"
    }
}
