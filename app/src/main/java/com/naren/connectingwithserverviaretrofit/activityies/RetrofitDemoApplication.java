package com.naren.connectingwithserverviaretrofit.activityies;

import android.app.Application;

/**
 * Created by narendra on 10/2/18.
 */

public class RetrofitDemoApplication extends Application {
    private static RetrofitDemoApplication       sSingleton;
    @Override
    public void onCreate() {
        super.onCreate();
        sSingleton = this;
    }

    ////
    // get instance of application
    ///
    public synchronized static RetrofitDemoApplication singleton()
    {
        return sSingleton;
    }

}
