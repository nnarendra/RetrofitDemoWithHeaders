package com.naren.connectingwithserverviaretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by narendra on 10/2/18.
 */

public class Post {

    @SerializedName("postId")
    @Expose
    public Integer postId;
    @SerializedName("contents")
    @Expose
    public Object contents;
    @SerializedName("postTimestamp")
    @Expose
    public String postTimestamp;
    @SerializedName("category")
    @Expose
    public String category;
    @SerializedName("rideId")
    @Expose
    public Integer rideId;
    @SerializedName("images")
    @Expose
    public Object images;
    @SerializedName("sharedPostId")
    @Expose
    public Object sharedPostId;
    @SerializedName("privacy")
    @Expose
    public String privacy;
    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("photo")
    @Expose
    public String photo;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("ownerCommented")
    @Expose
    public Boolean ownerCommented;
    @SerializedName("comments")
    @Expose
    public List<Object> comments = null;
    @SerializedName("commentCount")
    @Expose
    public Integer commentCount;
    @SerializedName("shareCount")
    @Expose
    public Integer shareCount;
    @SerializedName("commented")
    @Expose
    public Boolean commented;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("ownerLiked")
    @Expose
    public Boolean ownerLiked;
    @SerializedName("liked")
    @Expose
    public Boolean liked;
    @SerializedName("ride")
    @Expose
    public Ride ride;

    public class Image {

        @SerializedName("vehicleImage")
        @Expose
        public String vehicleImage;

    }

    public class Ride {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("user_id")
        @Expose
        public Integer userId;
        @SerializedName("src_lat")
        @Expose
        public String srcLat;
        @SerializedName("src_lng")
        @Expose
        public String srcLng;
        @SerializedName("dest_lat")
        @Expose
        public String destLat;
        @SerializedName("dest_lng")
        @Expose
        public String destLng;
        @SerializedName("src_addr")
        @Expose
        public String srcAddr;
        @SerializedName("dest_addr")
        @Expose
        public String destAddr;
        @SerializedName("distance")
        @Expose
        public String distance;
        @SerializedName("vehicle_id")
        @Expose
        public Integer vehicleId;
        @SerializedName("ride_time")
        @Expose
        public String rideTime;
        @SerializedName("ride_date")
        @Expose
        public String rideDate;
        @SerializedName("seat")
        @Expose
        public Integer seat;
        @SerializedName("ride_type")
        @Expose
        public String rideType;
        @SerializedName("is_dropped")
        @Expose
        public Integer isDropped;
        @SerializedName("is_started")
        @Expose
        public Integer isStarted;
        @SerializedName("requested_vehicle")
        @Expose
        public String requestedVehicle;
        @SerializedName("overview_polyline")
        @Expose
        public String overviewPolyline;
        @SerializedName("ride_status")
        @Expose
        public String rideStatus;
        @SerializedName("reason")
        @Expose
        public Object reason;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("deleted_at")
        @Expose
        public Object deletedAt;
        @SerializedName("vehicle")
        @Expose
        public Vehicle vehicle;

    }

    public class Vehicle {

        @SerializedName("vehicleName")
        @Expose
        public String vehicleName;
        @SerializedName("reg_no")
        @Expose
        public String regNo;
        @SerializedName("model_name")
        @Expose
        public String modelName;
        @SerializedName("manufacturer")
        @Expose
        public String manufacturer;
        @SerializedName("color_name")
        @Expose
        public String colorName;
        @SerializedName("fuel")
        @Expose
        public String fuel;
        @SerializedName("image")
        @Expose
        public List<Image> image = null;

    }
}
