package com.example.pr12;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeJsonFile();

    }

    void ParseJson()
    {
        Gson gson = new Gson();
        String gsoncarData = "{\"brand\":\"AvtoVAZ\", \"build_year\":1994,\"type\":\"sedan\"}";
        Car vaz2107 = gson.fromJson(gsoncarData,Car.class);
        Toast.makeText(MainActivity.this,vaz2107.getBrand()+vaz2107.getType()+String.valueOf(vaz2107.getBuild_year()),Toast.LENGTH_LONG).show();

    }

    void MakeJsonFile()
    {
        Car car = new Car("BMW", 2001, "SUV");
        Gson gson = new Gson();

        try
        {
            FileOutputStream fileOutputStream = openFileOutput("Data.json", this.MODE_APPEND);
            fileOutputStream.write(gson.toJson(car).getBytes());
            Toast.makeText(this, getFilesDir().getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}