package com.example.machenike.netdemo8;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MACHENIKE on 2017/7/12.
 */

public class RetrofitNetClient {
    private static RetrofitNetClient mRetrofitNetClient;
    private final Retrofit mRetrofit;

    private RetrofitNetClient(){
        //创建一个日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建OkHttpClient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        //创建一个Retrofit对象
        //必须要写，方便跟后面的相对路径进行拼接，组成完整的URL(若发现后面的路径是绝对路径则不拼接)
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com") //必须要写，方便跟后面的相对路径进行拼接，组成完整的URL(若发现后面的路径是绝对路径则不拼接)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RetrofitApi getRetrofitApi(){
        return mRetrofit.create(RetrofitApi.class);
    }
    public static synchronized RetrofitNetClient getInstance(){
        if (mRetrofitNetClient==null){
            mRetrofitNetClient = new RetrofitNetClient();
        }
        return  mRetrofitNetClient;
    }
}
