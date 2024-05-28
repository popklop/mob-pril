package com.example.pr12_2;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

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
        Uri uri = Uri.parse("content://com.example.pr102/heroes");
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(uri, new String[]{"id","hero_name","attribute", "attack_type", "difficulty_level"}, null, null, null);
        if (cursor != null) {
            try {
                int _hero_name = cursor.getColumnIndex("hero_name");
                int _id = cursor.getColumnIndex("id");
                int _attribute = cursor.getColumnIndex("attribute");
                int _attack_type = cursor.getColumnIndex("attack_type");
                int _difficulty_level = cursor.getColumnIndex("difficulty_level");
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(_id);
                    String heroname = cursor.getString(_hero_name);
                    String attribute = cursor.getString(_attribute);
                    String attack_type = cursor.getString(_attack_type);
                    int dif_lvl = cursor.getInt(_difficulty_level);
                    Toast.makeText(this, String.valueOf(id) + " " + heroname + " " + attribute + " " + attack_type + " " + String.valueOf(dif_lvl), Toast.LENGTH_LONG).show();
                }
            } finally {
                cursor.close();
            }
        } else {
            Toast.makeText(this, "Cursor is null", Toast.LENGTH_LONG).show();
        }

    }
}