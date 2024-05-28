package com.example.pr8;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetJson
{
    @GET("woof.json")
    Call<Dog> getdogimage();
}
