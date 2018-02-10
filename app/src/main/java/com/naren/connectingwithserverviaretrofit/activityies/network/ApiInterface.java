package com.naren.connectingwithserverviaretrofit.activityies.network;

import com.google.gson.JsonElement;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by narendra on 20/01/18.
 */

public interface ApiInterface {



    @POST("users/login")
    Call<JsonElement> doLogin(@Body HashMap<String,String> map);

    @GET("posts/posts")
    Call<JsonElement> getFeedList();


}
