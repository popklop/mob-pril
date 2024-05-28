package com.example.pr7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service
{
    private static final String TAG = "MusicService";
    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate()
    {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this,R.raw.muz);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
    }
    @Override
    public int onStartCommand(Intent intent, int flag, int StartId)
    {
        if (!mediaPlayer.isPlaying())
        {
            mediaPlayer.start();
            Log.d("Muz","Muz Stated");
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}