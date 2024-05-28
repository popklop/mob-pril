package com.example.pr3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView textVie= new TextView(this);
        textVie.setText("TEXT");
        textVie.setTextSize(40);
        textVie.setGravity(Gravity.CENTER);
        textVie.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setBackgroundColor(Color.RED);
        Button but = new Button(this);
        but.setText("Knopka");
        linearLayout.addView(textVie);
        linearLayout.addView(but);
        setContentView(linearLayout);
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
}