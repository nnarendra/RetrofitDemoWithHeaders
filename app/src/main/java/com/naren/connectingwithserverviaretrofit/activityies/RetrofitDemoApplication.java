package com.naren.connectingwithserverviaretrofit.activityies;

import android.app.Application;

import com.naren.connectingwithserverviaretrofit.activityies.network.ApiClient;
import com.naren.connectingwithserverviaretrofit.activityies.network.ApiInterface;

/**
 * Created by narendra on 10/2/18.
 */

public class RetrofitDemoApplication extends Application {
    public static ApiInterface sApiService;
    private static RetrofitDemoApplication sSingleton;

    ////
    // get instance of application
    ///
    public synchronized static RetrofitDemoApplication singleton() {
        return sSingleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sSingleton = this;
        sApiService =
                ApiClient.getApiClient().create(ApiInterface.class);
    }

}
