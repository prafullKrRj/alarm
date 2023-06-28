package com.example.alm;

import static android.app.PendingIntent.FLAG_MUTABLE;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class StartAlarm {

    private int hour;
    private int minute;

    public StartAlarm(Context context, int alarmHours, int alarmMins, int snoozeSeconds) {
        this.hour = alarmHours;
        this.minute = alarmMins;

        // Double check all values are in correct format
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.set(java.util.Calendar.HOUR_OF_DAY, alarmHours);
        c.set(java.util.Calendar.MINUTE,alarmMins);
        c.set(java.util.Calendar.SECOND,snoozeSeconds);

        // Set up an AlarmManager for monitored of time
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // Set up intent to initialise AlarmReceiver, a broadcast receiver.
        // PendingIntent links to alarm receiver. When a broadcast is received, the
        Intent alertIntent = new Intent(context, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, alertIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        if (c.before(java.util.Calendar.getInstance())) {
            c.add(java.util.Calendar.DATE, 1);
        }
        Toast.makeText(context, "step1", Toast.LENGTH_SHORT).show();
        alarmManager.setExact(AlarmManager.RTC, c.getTimeInMillis(), pendingIntent);
    }
}
