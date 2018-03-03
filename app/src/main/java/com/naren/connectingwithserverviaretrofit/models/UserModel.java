package com.naren.connectingwithserverviaretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by narendra on 10/2/18.
 */

public class UserModel {


    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("token")
    @Expose
    public String token;

    public class User {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("first_name")
        @Expose
        public String firstName;
        @SerializedName("last_lame")
        @Expose
        public String lastLame;
        @SerializedName("gender")
        @Expose
        public String gender;
        @SerializedName("username")
        @Expose
        public String username;
        @SerializedName("dob")
        @Expose
        public String dob;
        @SerializedName("phone_number")
        @Expose
        public String phoneNumber;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("photo")
        @Expose
        public String photo;
        @SerializedName("carbon_saved")
        @Expose
        public String carbonSaved;
        @SerializedName("total_travelled")
        @Expose
        public String totalTravelled;
        @SerializedName("is_vehicle_verified")
        @Expose
        public String isVehicleVerified;
        @SerializedName("is_personal_verified")
        @Expose
        public String isPersonalVerified;
        @SerializedName("is_email_verified")
        @Expose
        public Integer isEmailVerified;
        @SerializedName("has_wallet")
        @Expose
        public String hasWallet;

    }
}
