package com.example.pr8;


import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;
import retrofit2.Retrofit;

public class Dog
{
    @SerializedName("url")
    private String url = "url";
    public String getUrl()
    {
        return url;
    }
}
