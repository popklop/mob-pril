package com.example.pr4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String EXTRA_NAME = intent.getStringExtra("name");
        String EXTRA_SURN = intent.getStringExtra("surname");
        TextView textView1 = findViewById(R.id.textView);
        textView1.setText("\tДобро пожаловать, " + EXTRA_NAME);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(" " + EXTRA_SURN);
        textView1.setTextSize(22);
        textView2.setTextSize(22);
        Button button1 = findViewById(R.id.button_vvod);

        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>()
        {
            @Override
            public void onActivityResult(ActivityResult result)
            {
                if (result.getResultCode() == Activity.RESULT_OK)
                {
                    Intent date = result.getData();
                    if (date != null)
                    {
                        String date_string_extra = date.getStringExtra("date_num");
                        int date_int_extra = Integer.parseInt(date_string_extra);

                        if (date_int_extra < 0 || date_int_extra > 31)
                        {
                            Toast.makeText(MainActivity2.this, "Invalid date", Toast.LENGTH_LONG).show();
                        } else
                        {
                            Toast.makeText(MainActivity2.this, "OK, Dannie peredani", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else if (result.getResultCode() == Activity.RESULT_CANCELED)
                {
                    Toast.makeText(MainActivity2.this, "NOT OK", Toast.LENGTH_LONG).show();
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                resultLauncher.launch(intent1);
            }
        });
    }
}
