package com.example.pr5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Razdel_Nouti extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razdel_nouti);
        ListView listView = (ListView) findViewById(R.id.listnout);
        String[] noutTypesXML = getResources().getStringArray(R.array.nout_types);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,noutTypesXML);
        listView.setAdapter(arrayAdapter);
    }
}