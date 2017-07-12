package com.example.machenike.netdemo8;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by MACHENIKE on 2017/7/12.
 */

public interface RetrofitApi {
    //get请求
    @GET("https://api.github.com/{search}/repositories?q=language:java&page=1")
    //@Headers({"zxc:123,123:123,xx:11"}) 添加消息头
    Call<ResponseBody> getRetrofit(@Path("search")String search);

    //post请求
    @POST(" http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register")
    Call<UserResult> postRetrofit(@Body User user);

    //表单请求
    @FormUrlEncoded
    @POST(" http://wx.feicuiedu.com:9094/yitao/UserWeb?method=register")
    Call<ResponseBody> formRetrofit(@Field("username")String username,@Field("password")String password);

    //多部分请求
    @Multipart
    @POST("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=update")
    Call<ResponseBody> multiRetrofit(@Part("username")RequestBody username);


}
