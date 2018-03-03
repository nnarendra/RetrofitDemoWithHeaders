package com.naren.connectingwithserverviaretrofit.activityies;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.naren.connectingwithserverviaretrofit.R;


public class FeedActivity extends AppCompatActivity implements com.naren.connectingwithserverviaretrofit.managers.FeedManager.FeedListListener {


    private ProgressDialog mpProgressDialog;
    private RecyclerView mFeedRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mFeedRecyclerView=findViewById(R.id.feed_list);
        setSupportActionBar(toolbar);
        mpProgressDialog = new ProgressDialog(this);
        mpProgressDialog.setMessage("Loading.Please wait....");
        mpProgressDialog.show();
      com.naren.connectingwithserverviaretrofit.managers.FeedManager.singleton().getFeedList(this);
    }

    @Override
    public void onSuccess(com.naren.connectingwithserverviaretrofit.models.FeedMdel feedMdels) {
        mpProgressDialog.dismiss();
        //here we need to set adapter to the recycler view
        com.naren.connectingwithserverviaretrofit.adapters.FeedAdapter feedAdapter= new com.naren.connectingwithserverviaretrofit.adapters.FeedAdapter(feedMdels.postList,FeedActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mFeedRecyclerView.setLayoutManager(mLayoutManager);
        mFeedRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFeedRecyclerView.setAdapter(feedAdapter);

    }

    @Override
    public void onFailure(String errorMsg, Throwable error) {
        mpProgressDialog.dismiss();
        Toast.makeText(this,errorMsg,Toast.LENGTH_LONG).show();
    }
}
