package com.example.pr8;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.inthread);
        Button button2 = findViewById(R.id.notinthread);
        CheckBox checkBox = findViewById(R.id.checkBox);
        Data data = new Data.Builder().putString("Key", "SSSS").build();
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(Work.class).setInputData(data).build();
                WorkManager.getInstance(MainActivity.this).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).observe(MainActivity.this, new Observer<WorkInfo>()
                {
                    @Override
                    public void onChanged(WorkInfo workInfo)
                    {
                        Log.d("TAG", "work=" + workInfo.getState());
                        Log.d("TAG", "Data=" + workInfo.getOutputData().getString("Key"));
                    }
                });
                WorkManager.getInstance(MainActivity.this).enqueue(oneTimeWorkRequest);
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Thread.sleep(10000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                Log.d("NOTTHREAD", "Fin");
            }
        });

        OneTimeWorkRequest work1, work2, work3;
        work1 = new OneTimeWorkRequest.Builder(Work.class).build();
        work2 = new OneTimeWorkRequest.Builder(Work.class).build();
        work3 = new OneTimeWorkRequest.Builder(Work.class).build();
        List<OneTimeWorkRequest> list = new ArrayList<>(Arrays.asList(work1, work2));
        //WorkManager.getInstance(this).beginWith(work1).then(work2).then(work3).enqueue();
        WorkManager.getInstance(this).enqueue(list);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://random.dog/").addConverterFactory(GsonConverterFactory.create()).build();
        GetJson json = retrofit.create(GetJson.class);
        Button button = findViewById(R.id.dog);
        ImageView imageView = findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                json.getdogimage().enqueue(new Callback<Dog>()
                {
                    @Override
                    public void onResponse(Call<Dog> call, Response<Dog> response)
                    {
                        if (response.isSuccessful())
                        {
                            Dog dog = response.body();
                            assert dog != null;
                            String url = dog.getUrl();
                            Glide.with(MainActivity.this).load(url).into(imageView);
                        }
                    }

                    @Override
                    public void onFailure(Call<Dog> call, Throwable t)
                    {
                        Toast.makeText(MainActivity.this, "Ошибка", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}