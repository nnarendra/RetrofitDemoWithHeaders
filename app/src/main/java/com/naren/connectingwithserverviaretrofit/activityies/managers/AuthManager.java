package com.naren.connectingwithserverviaretrofit.activityies.managers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.naren.connectingwithserverviaretrofit.activityies.RetrofitDemoApplication;
import com.naren.connectingwithserverviaretrofit.activityies.models.UserModel;
import com.naren.connectingwithserverviaretrofit.activityies.utils.GSONUtility;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by narendra on 10/2/18.
 */

public class AuthManager {

    //constants
    private final static String TAG="AuthManager";
    //members
    private static AuthManager sSingleton;

    ///
    // Get instance.
    ///
    public static synchronized AuthManager singleton() {
        if (sSingleton == null) {
            sSingleton = new AuthManager();
        }

        return sSingleton;
    }

    public void login(String userName, String password, final LoginListener loginListener) {
        HashMap<String,String>requestBody=new HashMap<>();
        requestBody.put("email",userName);
        requestBody.put("password",password);

        Call<JsonElement> call = RetrofitDemoApplication.sApiService.doLogin(requestBody);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.i(TAG, response.toString());
                // response.
                JsonObject dataObj = GSONUtility.getJsonObjectSafe(response.body().getAsJsonObject(), "data");
                UserModel userModel = new Gson().fromJson(dataObj, UserModel.class);
                loginListener.onSuccess(userModel);

            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                // Log error here since request failed
                Log.i(TAG, t.getMessage());
                loginListener.onFailure(t.getMessage(),t);
                t.printStackTrace();
            }
        });

    }


    public interface LoginListener {
        void onSuccess(UserModel userModel);
        void onFailure(String errorMsg,Throwable error);
    }


}
