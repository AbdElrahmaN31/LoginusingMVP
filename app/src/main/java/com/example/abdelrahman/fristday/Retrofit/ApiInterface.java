package com.example.abdelrahman.fristday.Retrofit;

import com.example.abdelrahman.fristday.Model.CitiyResponse;
import com.example.abdelrahman.fristday.Model.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by AbdElrahman on 6/30/2018.
 */

public interface ApiInterface {
@POST("GetResponse")
Call<CitiyResponse> getClint();
@POST("Login")
 Call<LoginResponse>  login(@QueryMap Map<String , String > querymap);
}
