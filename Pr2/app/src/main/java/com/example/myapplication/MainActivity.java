package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.content.pm.PackageManager;

import com.example.myapplication.MainActivity2;


public class MainActivity extends AppCompatActivity
{
    public static String EXTRA_MESSAGE;
    public static int test=0;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("", "Create");
    }


    public void button2(View view)
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_BROWSER);
        try
        {
            startActivity(intent);
            Toast.makeText(this, "Браузер найден", Toast.LENGTH_LONG).show();
        } catch (ActivityNotFoundException e)
        {
            Toast.makeText(this, "Браузер не найден2", Toast.LENGTH_LONG).show();
        }
    }


    public void button1(View view)
    {
        Intent newAct = new Intent(this, MainActivity2.class);
        newAct.putExtra(EXTRA_MESSAGE, String.valueOf(test));
        startActivity(newAct);
        int sdk = Build.VERSION.SDK_INT;
        Toast.makeText(this, String.valueOf(sdk), Toast.LENGTH_LONG).show();
        test++;
    }

    @Override
    public void onStop()
    {
        Log.e("", "Stop");
        super.onStop();
    }

    @Override
    public void onPause()
    {
        Log.e("", "Pause");
        super.onPause();
    }

    @Override
    public void onDestroy()
    {
        Log.e("", "Destroy");
        super.onDestroy();
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState)
//    {
//        outState.putInt("Test_key",test);
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceSate)
//    {
//        test=savedInstanceSate.getInt("Test_key");
//        super.onRestoreInstanceState(savedInstanceSate);
//    }
}
