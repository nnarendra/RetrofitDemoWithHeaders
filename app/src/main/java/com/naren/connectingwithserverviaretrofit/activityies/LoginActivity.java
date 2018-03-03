package com.naren.connectingwithserverviaretrofit.activityies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.naren.connectingwithserverviaretrofit.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener, com.naren.connectingwithserverviaretrofit.managers.AuthManager.LoginListener {


    private Button mLogin;
    private EditText mUserName;
    private EditText mPassword;
    private ProgressDialog mpProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initAndSetClickListenersViews();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mpProgressDialog = new ProgressDialog(this);
        mpProgressDialog.setMessage("Loading.Please wait....");

    }

    private void initAndSetClickListenersViews() {
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
                login();
                break;
            case R.id.btn_sign_up:
            case R.id.iv_twitter_login:
            case R.id.iv_linked_login:
            case R.id.iv_google_login:
            case R.id.iv_facebook_login:
            case R.id.tv_forgot_pwd:
                Snackbar.make(view, "Need to implement this function", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                break;
            default:
                break;
        }
    }

    private void login() {
        if(!mUserName.getText().toString().equals("")
                &&(!mPassword.getText().toString().equals("")&&mPassword.getText().toString().length()>=6)){
            doLogin(mUserName.getText().toString(),mPassword.getText().toString());
        }else {
            Toast.makeText(this,"Please check user name or password",Toast.LENGTH_LONG).show();

        }
    }

    private void doLogin(String userName, String password) {
        mpProgressDialog.show();
        com.naren.connectingwithserverviaretrofit.managers.AuthManager.singleton().login(userName,password,this);
    }

    @Override
    public void onSuccess(com.naren.connectingwithserverviaretrofit.models.UserModel userModel) {
        mpProgressDialog.dismiss();
        com.naren.connectingwithserverviaretrofit.managers.SharedPreferenceManager.singleton().save("token",userModel.token);
        startActivity(new Intent(LoginActivity.this,FeedActivity.class));

    }

    @Override
    public void onFailure(String errorMsg, Throwable error) {
        mpProgressDialog.dismiss();
        Toast.makeText(this,errorMsg,Toast.LENGTH_LONG).show();
    }
}
