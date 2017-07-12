package com.example.machenike.netdemo8;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by MACHENIKE on 2017/7/12.
 */

public interface RetrofitApi {
    @GET("https://api.github.com/search/repositories?q=language:java&page=1")
   Call<ResponseBody> getRetrofit();
}
