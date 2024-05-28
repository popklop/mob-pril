package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        TextView text= new TextView(this);
        text.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
        Toast.makeText(this,R.string.greetings,Toast.LENGTH_LONG).show();
        text.setTextSize(40);
        setContentView(text);
    }
}