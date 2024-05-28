package com.example.pr5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Razdel_TP extends AppCompatActivity
{
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String>seleceted= new ArrayList<>();
    ArrayList<String> tp_tupesArray= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razdel_tp);
        listView = (ListView) findViewById(R.id.listtp);
        String [] noutStringXML = getResources().getStringArray(R.array.tp_types);

        Collections.addAll(tp_tupesArray,noutStringXML);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, tp_tupesArray);
        listView.setAdapter(adapter);
        Button button1 = findViewById(R.id.addbut);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                add(v);
            }
        });
        Button button2 = findViewById(R.id.delbut);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                del(v);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String k=noutStringXML[position];
                seleceted.add(k);
            }
        });

    }

    void add(View v)
    {
        EditText editText = findViewById(R.id.editTextText);
        String val = editText.getText().toString();
        if (!val.isEmpty())
        {
            adapter.add(val);
            editText.setText("");
        }
        adapter.notifyDataSetChanged();
    }
    void del (View v)
    {
        for (int i=0;i<seleceted.size();i++)
        {
            adapter.remove(seleceted.get(i));
            listView.clearChoices();
            adapter.notifyDataSetChanged();
        }
    }
}