package ru.notasi.imagesgridjson.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {
    private static final String LINK = "https://dev-tasks.alef.im";

    private static Retrofit getRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(LINK)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient).build();

        return retrofit;
    }

    public static NetworkInterface getInterface() {
        NetworkInterface networkInterface = getRetrofit()
                .create(NetworkInterface.class);
        return networkInterface;
    }
}