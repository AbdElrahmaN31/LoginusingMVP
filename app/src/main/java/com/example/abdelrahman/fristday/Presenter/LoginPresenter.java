package com.example.abdelrahman.fristday.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.abdelrahman.fristday.Model.LoginResponse;
import com.example.abdelrahman.fristday.Model.User;
import com.example.abdelrahman.fristday.Retrofit.ApiClient;
import com.example.abdelrahman.fristday.Retrofit.ApiInterface;
import com.example.abdelrahman.fristday.Views.LoginVeiw;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    LoginVeiw loginView;
    Context context;
    public LoginPresenter(Context context, LoginVeiw loginView)
    {
        this.loginView=loginView;
        this.context=context;

    }

    public void login(String name, String password) {

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("emailOrPhone", name);
        queryMap.put("password", password);
        queryMap.put("token", "1");

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiInterface.login(queryMap);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("LoginResponse", response.raw().request().toString());

                if (response.isSuccessful())
                {
                    if(response.body().getSuccess().equals("ok")) {
                        User user = new User();
                        user.setName(response.body().getArabicName());
                        user.setUrl(response.body().getPic());
                        user.setid(response.body().getUserid());
                        loginView.openMain(user);
                    }
                    else
                    {
                        Toast.makeText(context,"error",Toast.LENGTH_LONG);

                    }

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Log.e("LoginFailure", call.request().toString());


            }
        });
    }
}