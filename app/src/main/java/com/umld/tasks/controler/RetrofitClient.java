package com.umld.tasks.controler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://142.93.254.19/";
    private static final String DESERIALIZATION_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static RetrofitClient mInstance;

    public static Retrofit initializeRetrofit() {
        return new Retrofit.Builder()
                .client(createHttpClient())
                .baseUrl(getApiUri())
                .addConverterFactory(GsonConverterFactory.create(createDefaultGson()))
                .build();
    }

    private static HttpLoggingInterceptor createLoggingInterceptorForRetrofit()
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return logging;
    }

    private static OkHttpClient createHttpClient() {
        return new OkHttpClient.Builder()
                //.interceptors()      //ovde bi treba da dodje token i uvek da ostane
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(createLoggingInterceptorForRetrofit())
                .build();
    }

    protected static Gson createDefaultGson() {
        return new GsonBuilder()
                .setDateFormat(DESERIALIZATION_DATE_FORMAT)
                .create();
    }

    private static HttpUrl getApiUri() {
        HttpUrl httpUrl = HttpUrl.parse(BASE_URL);
        if(httpUrl == null) {
            httpUrl = HttpUrl.parse(BASE_URL);
        }
        return httpUrl;
    }

    public static synchronized RetrofitClient getInstance() {
        if(mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

}
