package com.naren.connectingwithserverviaretrofit.activityies.network;

import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.naren.connectingwithserverviaretrofit.activityies.managers.SharedPreferenceManager;
import com.naren.connectingwithserverviaretrofit.activityies.utils.GSONUtility;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by narendra on 10/2/18.
 */

 public class Interceptor implements okhttp3.Interceptor {


    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        //Get the original request
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .header("ApplicationId", "MC12");
        if (!SharedPreferenceManager.singleton().getString("token").equals("")) {
            requestBuilder.header("Token", SharedPreferenceManager.singleton().getString("token"));
        }
        Request request = requestBuilder.build();

        Log.i("Retrofit URL :: ", request.url().toString());
        if (request.headers() != null) {
            Log.i("Retrofit Headers :: ", request.headers().toMultimap().toString());
        }
        if (request.body() != null) {
            Log.i("Retrofit Body :: ", bodyToString(request));
        }
        Response response = null;
        try {


            //Hit the Server and get the response
            response = chain.proceed(request);
            String body = response.body().string();
            MediaType contentType = response.body().contentType();
            Log.i("Retrofit Response :: ", body);
            JsonObject apiResponse = new JsonParser().parse(body).getAsJsonObject();
            String status = GSONUtility.getStringSafe(apiResponse, "status");
            //Parse the response for
            //    1. Checking for status  "Ok"

            if (status.equals("OK")) {
                return response.newBuilder().body(ResponseBody.create(contentType, body)).build();
            } else {

                throw new ResponseException(GSONUtility.getStringSafe(apiResponse, "status"));
            }

        } catch (SocketTimeoutException ex) {
            ex.printStackTrace();
            throw new GenericException("Low Internet Or No Internet");
        } catch (JsonParseException e ) {
            e.printStackTrace();
            throw new GenericException("Oops! Something went wrong please try again later");
        }catch (NullPointerException e ) {
            e.printStackTrace();
            throw new GenericException("Oops! Something went wrong please try again later");
        }

    }


}
