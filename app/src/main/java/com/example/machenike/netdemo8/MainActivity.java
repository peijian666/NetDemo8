package com.example.machenike.netdemo8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_get)
    Button mBtnGet;
    @BindView(R.id.btn_post)
    Button mBtnPost;
    @BindView(R.id.btn_form)
    Button mBtnForm;
    @BindView(R.id.btn_multiPart)
    Button mBtnMultiPart;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get)
    public void onViewClicked() {
//        //创建OkHttpClient核心类
//        // OkHttpClient httpClient = new OkHttpClient();
//
//        //创建日志拦截器
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        //设置拦截器等级
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .build();
//        //--------------------get请求----------------------
//        //构建请求
////        Request request = new Request.Builder()
////                .url("https://api.github.com/search/repositories?q=language:java&page=1")
////                .get()
////                .build();
//        //------------------post请求-----------------------
//        //构建请求体
//        RequestBody requestBody = RequestBody.create(null, "{\n" +
//                "\"Password\":\"654321\",\n" +
//                "\"UserName\":\"qjd\"\n" +
//                "}");
//        Request request = new Request.Builder()
//                .url("http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register")
//                .post(requestBody)
//                .build();
//
//        //发送请求
//        //httpClient.newCall(request).execute()  同步请求
//        Call call = httpClient.newCall(request);
//        call.enqueue(new Callback() {
//            //失败
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d("TAG", "请求失败了！");
//            }
//
//            //成功
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("TAG", "响应数据:" + "响应体" + response.body().string());
//            }
//        });
        OkHttpNetClient.getInstance().getRequest().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("Get", "失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("Get", response.body().string());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick(R.id.btn_post)
    public void post() {
        OkHttpNetClient.getInstance().postRequest().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("POST", "失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.d("POST", response.body().string());
            }
        });
    }

    @OnClick(R.id.btn_form)
    public void form() {
        OkHttpNetClient.getInstance().formRequest().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("Biaodan", "失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("Biaodan", response.body().string());
            }
        });
    }

    @OnClick(R.id.btn_multiPart)
    public void multiPart() {
        OkHttpNetClient.getInstance().multiPartRequest().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("multiPart", "失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("multiPart", response.body().string());
            }
        });
    }
}
