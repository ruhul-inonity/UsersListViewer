package com.inonitylab.userslistviewer.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inonitylab.userslistviewer.util.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ruhul on 4/9/18.
 */

public class RetrofitApiClient {
    private Retrofit retrofit = null;

    public Retrofit getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(1, TimeUnit.MINUTES);
        client.readTimeout(2, TimeUnit.MINUTES);
        client.writeTimeout(2, TimeUnit.MINUTES);

        client.addInterceptor(chain -> {

            Request request = chain.request().newBuilder()
                    .build();
            return chain.proceed(request);
        }).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        client.addNetworkInterceptor(logging);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;

    }
}
