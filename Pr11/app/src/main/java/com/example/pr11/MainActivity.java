package com.example.pr11;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    public static final String CHANNEL_ID= "example_channel";
    private  WebView webView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://online-edu.mirea.ru/course/view.php?id=6592");
        mediaPlayer = new MediaPlayer();
        try
        {
            mediaPlayer.setDataSource("https://track.pinkamuz.pro/play/333532b2b0343335368a3731353332b6047201/9971f6f74f268f353a0aa0c118f7596f/3.mp3");
            mediaPlayer.prepare();

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Button play_stop = findViewById(R.id.pauseresume);
        play_stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                }
                else
                {
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                }
            }
        });
        final Button notify = findViewById(R.id.notify);
        notify.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID).setSmallIcon(R.drawable.ic_action_name).setContentTitle("Hello").setContentText("How are you").setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.notify(1, builder.build());
            }
        });


        final Button delayednot = findViewById(R.id.delayed);
        delayednot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sheduleNotificatio(10000);
            }
        });



    }
    private void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            CharSequence name = "Example";
            String description = "Channel for example";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel= new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
    private void sheduleNotificatio(long delay)
    {
        Intent notfication= new Intent(MainActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0 , notfication,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long futureInMillis = System.currentTimeMillis()+delay;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,futureInMillis,pendingIntent);


    }

}