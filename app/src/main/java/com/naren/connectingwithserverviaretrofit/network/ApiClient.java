package com.naren.connectingwithserverviaretrofit.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by narendra on 20/01/18.
 */

public class ApiClient {


    public static final String BASE_URL = "http://mycotra.com/api/v1.0/";
    private static Retrofit sRetrofit = null;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    public static Retrofit getApiClient() {
        if (sRetrofit==null) {
            httpClient.connectTimeout(30_000, TimeUnit.MILLISECONDS);
            httpClient.readTimeout(30_000, TimeUnit.MILLISECONDS);
            httpClient.writeTimeout(30_000, TimeUnit.MILLISECONDS);
            httpClient.addInterceptor(new Interceptor());

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL )
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
