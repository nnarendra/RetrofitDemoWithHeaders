package com.naren.connectingwithserverviaretrofit.activityies.network;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by narendra on 20/01/18.
 */

public interface ApiInterface {



    @GET("rest/")
    Call<JsonElement> getImageList(@Query("method") String methodValue, @Query("api_key") String apKeyValue, @Query("per_page") int perPage,
                                   @Query("page") int page, @Query("format") String format, @Query("nojsoncallback") int callbackValue);


}
