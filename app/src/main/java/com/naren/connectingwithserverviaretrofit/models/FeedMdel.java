package com.naren.connectingwithserverviaretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by narendra on 10/2/18.
 */

public class FeedMdel {
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("per_page")
    @Expose
    public Integer perPage;
    @SerializedName("current_page")
    @Expose
    public Integer currentPage;
    @SerializedName("last_page")
    @Expose
    public Integer lastPage;
    @SerializedName("next_page_url")
    @Expose
    public String nextPageUrl;
    @SerializedName("prev_page_url")
    @Expose
    public Object prevPageUrl;
    @SerializedName("from")
    @Expose
    public Integer from;
    @SerializedName("to")
    @Expose
    public Integer to;

    public List<com.naren.connectingwithserverviaretrofit.models.Post> postList;


    public void setPostList(List<com.naren.connectingwithserverviaretrofit.models.Post> postList){
        this.postList=postList;
    }

}
