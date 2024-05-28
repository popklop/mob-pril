package com.example.pr112;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
        ImageView rortateimageView = findViewById(R.id.imageView);
        ObjectAnimator rotateimage  = ObjectAnimator.ofFloat(rortateimageView, "rotation",0f, 360f);
        rotateimage.setDuration(10000);
        rotateimage.setRepeatCount(ObjectAnimator.INFINITE);
        rotateimage.setRepeatMode(ObjectAnimator.RESTART);
        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ObjectAnimator changex = ObjectAnimator.ofFloat(textView,"scaleX", 1f, 2f);
                ObjectAnimator changey = ObjectAnimator.ofFloat(textView,"scaleY", 1f, 2f);
                changey.setDuration(1000);
                changex.setDuration(1000);
                changex.start();
                changey.start();
            }
        });
        rotateimage.start();

        final TextView textView1 = findViewById(R.id.textView2);
        textView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ObjectAnimator move = ObjectAnimator.ofFloat(textView1,"translationX",0f,300f );
                move.setDuration(1000);
                move.start();
            }
        });
    }
}