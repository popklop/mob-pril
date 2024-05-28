package com.example.pr4;

        import androidx.activity.result.ActivityResult;
        import androidx.appcompat.app.AppCompatActivity;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import java.util.Date;

public class MainActivity3 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        Button button = findViewById(R.id.buttonOK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editTextText4);
                String temp = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("date_num", temp);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        Button buttonNotOk= findViewById(R.id.buttonNotOk);
        buttonNotOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

    }
}
