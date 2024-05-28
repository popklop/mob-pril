package com.example.pr8;

import android.content.Context;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.jetbrains.annotations.NotNull;

public class Work3 extends Worker
{
    String x;
    Data dataout;
    public static String tag ="TEST";
    public Work3(@NotNull Context context, @NotNull WorkerParameters workerParameters)
    {
        super(context, workerParameters);
        x = getInputData().getString("Key");
        dataout  = new Data.Builder().putString("Key","outdata").build();
    }
    @NotNull
    @Override
    public Result doWork()
    {
        try
        {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("TAG","Work"+x);
        return Worker.Result.success(dataout);
    }

}
