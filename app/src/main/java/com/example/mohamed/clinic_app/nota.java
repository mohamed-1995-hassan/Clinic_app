package com.example.mohamed.clinic_app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Mohamed on 24/10/2018.
 */
public class nota extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nm= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent op=new Intent(context,final11.class);

        op.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pnn=PendingIntent.getActivity(context,0,op,PendingIntent.FLAG_UPDATE_CURRENT);
        Uri alarmsound= RingtoneManager.getDefaultUri(RingtoneManager.ID_COLUMN_INDEX);
        NotificationCompat.Builder mynotify=new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                .setContentTitle("notetitle")
                .setContentText("notetext")
                .setAutoCancel(true)
                .setContentIntent(pnn)
                .setSound(alarmsound);
        nm.notify(100,mynotify.build());








        /*
        Calendar cl=Calendar.getInstance();
        cl.set(Calendar.HOUR_OF_DAY,15);
        cl.set(Calendar.MINUTE,15);
        cl.set(Calendar.SECOND,30);
        Intent ii=new Intent(this,nota.class);
        PendingIntent pi=PendingIntent.getBroadcast(this,12,ii,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager al = (AlarmManager) getSystemService(ALARM_SERVICE);
        al.setRepeating(AlarmManager.RTC_WAKEUP,cl.getTimeInMillis(),30000,pi);


         */

    }
}

