package com.naren.connectingwithserverviaretrofit.activityies.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.naren.connectingwithserverviaretrofit.activityies.RetrofitDemoApplication;

/**
 * Created by narendra on 10/2/18.
 */

public class SharedPreferenceManager {

    // members
    private static SharedPreferenceManager sSingleton;
    // constants.
    private final String PREFERENCES = "preferences";
    private SharedPreferences mSharedPreference;

    ///
    // constructor
    ///
    private SharedPreferenceManager() {
            mSharedPreference = RetrofitDemoApplication.singleton().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    ///
    // Get instance.
    ///
    public static synchronized SharedPreferenceManager singleton() {
        if (sSingleton == null) {
            sSingleton = new SharedPreferenceManager();
        }

        return sSingleton;
    }

    ///
    // Save data in shared pref.
    ///
    public void save(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreference.edit();
        editor.putString(key, value);
        editor.commit();
    }


    ///
    // Get String
    ///
    public String getString(String key) {
        return mSharedPreference.getString(key, "");
    }
}
