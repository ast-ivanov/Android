package com.nstu.fami.lab6;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final static int NOTIFY_ID = 101;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleHandler(View v) {
        Context context = getApplicationContext();

        Intent notificationIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://microsoft.com"));
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = context.getResources();
        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentIntent(contentIntent)
                .setSmallIcon(android.R.drawable.stat_sys_upload)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.hungry))
                .setTicker("Последнее китайское предупреждение!")
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setContentTitle("Напоминание")
                .setContentText("Пора покормить кота"); // Текст уведомления

        Notification notification = builder.build();

        if (notificationManager == null) {
            notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        notificationManager.notify(0, notification);

    }

    public void sendActionNotification(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Намерение для запуска второй активности
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        // Строим уведомление
        Notification builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Посылка")
                .setContentText("Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(android.R.drawable.sym_action_email).setContentIntent(pIntent)
                .addAction(android.R.drawable.checkbox_on_background, "Открыть", pIntent)
                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Отказаться", pIntent)
                .addAction(android.R.drawable.arrow_up_float, "Другой вариант", pIntent)
                .build();

        // убираем уведомление, когда его выбрали
        builder.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(1, builder);
    }

    public void sendBigTextStyleNotification(View view) {
        String bigText = "Это я, почтальон Печкин. Принес для вас посылку. "
                + "Только я вам ее не отдам. Потому что у вас документов нету. ";

        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Уведомление с большим текстом")
                .setContentText("Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(android.R.drawable.sym_action_email)
                .addAction(android.R.drawable.checkbox_on_background, "Запустить активность", pIntent)
                .setAutoCancel(true);

        Notification notification = new Notification.BigTextStyle(builder)
                .bigText(bigText).build();

        if (notificationManager == null) {
            notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        }
        notificationManager.notify(2, notification);
    }

    public void sendBigPictureStyleNotification(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Большая посылка")
                .setTicker("Пришла посылка!")
                .setContentText("Уведомление с большой картинкой")
                .setSmallIcon(android.R.drawable.sym_action_email)
                .addAction(android.R.drawable.checkbox_on_background, "Запустить активность", pIntent);

        // Подготовим большую картинку
        Notification notification = new Notification.BigPictureStyle(builder)
                .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.hungry))
                .build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        if (notificationManager == null) {
            notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        }
        notificationManager.notify(3, notification);
    }

    public void sendInboxStyleNotification(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Уведомление в стиле Inbox")
                .setContentText("Inbox Style notification!!")
                .setSmallIcon(android.R.drawable.sym_action_email)
                .addAction(android.R.drawable.checkbox_on_background, "Запустить активность", pIntent);

        Notification notification = new Notification.InboxStyle(builder)
                .addLine("Первое сообщение").addLine("Второе сообщение")
                .addLine("Третье сообщение").addLine("Четвертое сообщение")
                .setSummaryText("+2 more").build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        if (notificationManager == null) {
            notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        }
        notificationManager.notify(4, notification);
    }

    public void deleteHandler(View v) {
        if (notificationManager != null) {
            for (int i = 0; i < 5; ++i) {
                notificationManager.cancel(i);
            }
        }
    }
}
