package com.shabayekdes.shabayekdes;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class NotifyActivity extends AppCompatActivity {
    NotificationManager nmanger;
    static int id = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        nmanger = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    }

    public void addNotify(View view) {
        NotificationCompat.Builder nbuilder = new NotificationCompat.Builder(this);
        nbuilder.setContentTitle("Danger")
                .setContentText("You are click notification")
                .setSmallIcon(R.drawable.gps);

        Intent resintent = new Intent(this,TopMoviesActivity.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);

        taskStackBuilder.addParentStack(TopMoviesActivity.class);
        taskStackBuilder.addNextIntent(resintent);

        PendingIntent respending = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        nbuilder.setContentIntent(respending);
        nbuilder.addAction(0,"Go",respending);


        nmanger.notify(id,nbuilder.build());
        id++;
    }

    public void removeNotify(View view) {
    nmanger.cancelAll();
    }
}
