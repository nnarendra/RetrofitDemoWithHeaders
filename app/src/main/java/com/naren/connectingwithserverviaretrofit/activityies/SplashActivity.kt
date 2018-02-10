package com.naren.connectingwithserverviaretrofit.activityies

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.naren.connectingwithserverviaretrofit.R
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

            val i = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(i)

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)

    }

    override fun onBackPressed() {

    }
}
