package com.example.abdelrahman.fristday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.abdelrahman.fristday.Model.User;
import com.example.abdelrahman.fristday.Presenter.LoginPresenter;
import com.example.abdelrahman.fristday.Views.LoginVeiw;

public class MainActivity extends AppCompatActivity implements LoginVeiw {
    EditText Email,Password;
    Button Login;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginPresenter = new LoginPresenter(this, (LoginVeiw) this);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.log_in);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                openMain(user);
            }
        });
    }

    @Override
    public void openMain(User user) {

    }

    @Override
    public void showErrorMessage() {

    }
}
