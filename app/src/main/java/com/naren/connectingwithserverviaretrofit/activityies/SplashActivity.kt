package com.naren.connectingwithserverviaretrofit.activityies

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.naren.connectingwithserverviaretrofit.R
import com.naren.connectingwithserverviaretrofit.managers.SharedPreferenceManager
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {


    // Splash screen timer
    private val SPLASH_TIME_OUT:Long = 3000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setSupportActionBar(toolbar)
        Handler().postDelayed(Runnable
        {

           if(SharedPreferenceManager.singleton().getString("token").equals("")){
               startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
           }else{
               startActivity(Intent(this@SplashActivity, FeedActivity::class.java))
           }


            // close this activity
            finish()
        }, SPLASH_TIME_OUT)

    }

    override fun onBackPressed() {

    }
}
