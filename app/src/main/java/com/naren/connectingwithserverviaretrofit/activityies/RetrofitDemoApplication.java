package com.naren.connectingwithserverviaretrofit.activityies;

import android.app.Application;



/**
 * Created by narendra on 10/2/18.
 */

public class RetrofitDemoApplication extends Application {
    public static com.naren.connectingwithserverviaretrofit.network.ApiInterface sApiService;
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
                com.naren.connectingwithserverviaretrofit.network.ApiClient.getApiClient().create(com.naren.connectingwithserverviaretrofit.network.ApiInterface.class);
    }

}
