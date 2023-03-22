package com.google.colorgame;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/*
*
* ReceiveNotification is responsible to display the notification.
*
 */
public class ReceiveNotification extends BroadcastReceiver
{
    // Function to display the details of the notification ex: title and the content text of the notification
    // and to open the MainActivity when the user pressing on the notification.
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Intent mainWhenPressing = new Intent(context, MainActivity.class);
        @SuppressLint("UnspecifiedImmutableFlag")
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, mainWhenPressing, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notify").setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle(context.getString(R.string.app_name)).setContentText(context.getString(R.string.notification_msg)).setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true).setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(200, builder.build());
    }

}