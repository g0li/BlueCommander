package com.copiacs.bluecommander.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.copiacs.bluecommander.HomeActivity;
import com.copiacs.bluecommander.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.fpass).setOnClickListener(this);
        findViewById(R.id.reg).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=null;
        switch (v.getId())
        {
            case R.id.login:
                i=new Intent(LoginActivity.this, HomeActivity.class);
                break;
            case R.id.fpass:
                i=new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                break;
            case R.id.reg:
                i=new Intent(LoginActivity.this, RegisterActivity.class);
                break;
        }
        startActivity(i);

    }
}
