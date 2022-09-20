package com.if5b.myalarm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AlarmReceiver extends BroadcastReceiver {
    public static final String TYPE_ONE_TIME = "OneTimeAlarm";
    public static final String TYPE_REPEATING = "RepeatingAlarm";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_TYPE = "type";
    private static final int ID_ONETIME = 100;
    private static final int ID_REPEATING = 101;
    private static final String CHANNEL_ID = "channel_notif_alarm";
    private static final CharSequence CHANNEL_NAME = "Alarm Channel";

    public AlarmReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
            String type = intent.getStringExtra(EXTRA_TYPE);
            String message = intent.getStringExtra(EXTRA_MESSAGE);

            String title = type.equalsIgnoreCase(TYPE_ONE_TIME) ? TYPE_ONE_TIME : TYPE_REPEATING;
            int notifId = type.equalsIgnoreCase(TYPE_ONE_TIME) ? ID_ONETIME : ID_REPEATING;

            showAlarmNotification(context, title, message, notifId);
    }

    private void showAlarmNotification(Context context, String title, String message, int notifId) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_white_access_time_24)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(ContextCompat.getColor(context, android.R.color.transparent))
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setSound(alarmSound);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[] {1000, 1000, 1000, 1000, 1000});
            mBuilder.setChannelId(CHANNEL_ID);

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        Notification notification = mBuilder.build();

        if(notificationManager != null) {
            notificationManager.notify(notifId, notification);
        }
    }

    public boolean isAlarmSet(Context context, String type) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        int requestCode = type.equalsIgnoreCase(TYPE_ONE_TIME) ? ID_ONETIME : ID_REPEATING;

        return PendingIntent.getBroadcast(context, requestCode, intent, PendingIntent.FLAG_NO_CREATE) != null;
    }

    public boolean isDateInvalid(String date, String format) {
        DateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        df.setLenient(false);
        try {
            df.parse(date);
            return false;
        }
        catch (ParseException e) {
            e.printStackTrace();
            return true;
        }
    }
}
