package com.naren.connectingwithserverviaretrofit.activityies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.naren.connectingwithserverviaretrofit.R;
import com.naren.connectingwithserverviaretrofit.activityies.managers.FeedManager;
import com.naren.connectingwithserverviaretrofit.activityies.models.FeedMdel;

public class FeedActivity extends AppCompatActivity implements FeedManager.FeedListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      FeedManager.singleton().getFeedList(this);
    }

    @Override
    public void onSuccess(FeedMdel feedMdels) {

    }

    @Override
    public void onFailure(String errorMsg, Throwable error) {

    }
}
