package com.naren.connectingwithserverviaretrofit.activityies.managers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.naren.connectingwithserverviaretrofit.activityies.RetrofitDemoApplication;
import com.naren.connectingwithserverviaretrofit.activityies.models.FeedMdel;
import com.naren.connectingwithserverviaretrofit.activityies.models.Post;
import com.naren.connectingwithserverviaretrofit.activityies.utils.GSONUtility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by narendra on 10/2/18.
 */

public class FeedManager {

    //constants
    private final static String TAG = "FeedManager";
    //members
    private static FeedManager sSingleton;

    ///
    // Get instance.
    ///
    public static synchronized FeedManager singleton() {
        if (sSingleton == null) {
            sSingleton = new FeedManager();
        }

        return sSingleton;
    }

    public void getFeedList(final FeedListListener feedListListener) {


        Call<JsonElement> call = RetrofitDemoApplication.sApiService.getFeedList();
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.i(TAG, response.toString());
                // response.
                JsonObject dataObJ = GSONUtility.getJsonObjectSafe(response.body().getAsJsonObject(), "data");
                JsonObject postsObj = GSONUtility.getJsonObjectSafe(dataObJ.getAsJsonObject(), "posts");
                JsonArray postsArray = GSONUtility.getJsonArraySafe(postsObj, "posts");
                 FeedMdel feedMdel = new Gson().fromJson(postsObj, FeedMdel.class);
                List<Post> posts = new ArrayList<>();
                for (JsonElement element : postsArray) {
                    Post post = new Gson().fromJson(element, Post.class);
                    posts.add(post);
                }
                feedMdel.setPostList(posts);


                // UserModel userModel = new Gson().fromJson(dataObj, UserModel.class);
                feedListListener.onSuccess(feedMdel);

            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                // Log error here since request failed
                Log.i(TAG, t.getMessage());
                feedListListener.onFailure(t.getMessage(), t);
                t.printStackTrace();
            }
        });

    }


    public interface FeedListListener {

        void onSuccess(FeedMdel feedMdel);

        void onFailure(String errorMsg, Throwable error);
    }
}
