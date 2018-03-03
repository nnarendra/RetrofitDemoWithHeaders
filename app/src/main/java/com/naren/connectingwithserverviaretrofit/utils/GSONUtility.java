package com.naren.connectingwithserverviaretrofit.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by narendra on 2/11/18.
 */

public class GSONUtility {

    public static String getStringSafe(JsonObject json, String key) {
        return json.get(key) != null && !json.get(key).isJsonNull() ?  json.get(key).getAsString() : null;
    }

    public static int getIntegerSafe(JsonObject json, String key) {
        return json.get(key) != null && !json.get(key).isJsonNull() ? json.get(key).getAsInt() : 0 ;
    }

    public static long getLongSafe(JsonObject json, String key) {
        return json.get(key) != null && !json.get(key).isJsonNull() ? json.get(key).getAsLong() : 0 ;
    }

    public static int getIntegerWithPenalty(JsonObject json, String key) {

        return json.get(key) != null && !json.get(key).isJsonNull() ? json.get(key).getAsInt() : -1 ;
    }

    public static double getDoubleSafe(JsonObject json, String key) {
        return json.get(key) != null && !json.get(key).isJsonNull() ? json.get(key).getAsDouble() : 0 ;
    }

    public static float getFloatSafe(JsonObject json, String key) {
        return json.get(key) != null && !json.get(key).isJsonNull() ? json.get(key).getAsFloat() : 0 ;
    }

    public static boolean getBooleanSafe(JsonObject json, String key) {
        return json.get(key) != null && !json.get(key).isJsonNull() ? json.get(key).getAsBoolean() : false ;
    }

    public static JsonArray getJsonArraySafe(JsonObject json, String key) {

        return json.get(key) != null && !json.get(key).isJsonNull() ? json.get(key).getAsJsonArray() : new JsonArray();
    }
    public static JsonObject getJsonObjectSafe(JsonObject json, String key) {

        return json.get(key) != null && !json.get(key).isJsonNull() ? json.get(key).getAsJsonObject() :new JsonObject();
    }




    public static JsonElement getJSONElementFromString(String str) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson (str, JsonElement.class);
        return element;
    }





}
