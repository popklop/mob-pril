package com.example.pr10;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview);
        SharedPreferences sharedPreferences = getSharedPreferences("Test",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        Button delete = findViewById(R.id.deldata);
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editor.clear();
                editor.apply();
            }
        });
        Button save = findViewById(R.id.savedata);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editor.putString("Name", "Elmar");
                editor.putString("Surname", "Nagiev");
                editor.putInt("AGE", 19);
                editor.apply();
            }
        });
        Button getdata = findViewById(R.id.getData);
        getdata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name = sharedPreferences.getString("Name", "null");
                String surname = sharedPreferences.getString("Surname", "null");
                int age = sharedPreferences.getInt("AGE", 0);

                textView.setText(name+"\n"+surname+"\n"+ String.valueOf(age));
                textView.setTextSize(32);

            }
        });


    }
}