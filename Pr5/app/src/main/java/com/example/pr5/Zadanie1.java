package com.example.pr5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Zadanie1 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie1);
        ListView listView = (ListView) findViewById(R.id.listview1);
        String[] names = getResources().getStringArray(R.array.electronics_type);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent;
                switch (position)
                {
                    case 0:
                        intent= new Intent(Zadanie1.this, Razdel_TP.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent= new Intent(Zadanie1.this, Razdel_Nouti.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(Zadanie1.this, "Esho ne gotovo", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }
}