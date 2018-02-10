package com.naren.connectingwithserverviaretrofit.activityies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.naren.connectingwithserverviaretrofit.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mLogin;
    private EditText mUserName;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initAndSetClickLisnarsViews();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    private void initAndSetClickLisnarsViews() {
        mLogin = findViewById(R.id.btn_login);
        mLogin.setOnClickListener(this);
        mUserName = findViewById(R.id.et_user_name);
        mPassword = findViewById(R.id.et_password);

        findViewById(R.id.tv_forgot_pwd).setOnClickListener(this);
        findViewById(R.id.iv_facebook_login).setOnClickListener(this);
        findViewById(R.id.iv_google_login).setOnClickListener(this);
        findViewById(R.id.iv_linked_login).setOnClickListener(this);
        findViewById(R.id.iv_twitter_login).setOnClickListener(this);
        findViewById(R.id.btn_sign_up).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_login:
                break;

            case R.id.btn_sign_up:
            case R.id.iv_twitter_login:
            case R.id.iv_linked_login:
            case R.id.iv_google_login:
            case R.id.iv_facebook_login:
            case R.id.tv_forgot_pwd:
                //TODO need to give toast

                break;


            default:
                break;

        }

    }
}
