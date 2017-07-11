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
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_get)
    Button mBtnGet;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get)
    public void onViewClicked() {
        //创建OkHttpClient核心类
        OkHttpClient httpClient = new OkHttpClient();
        //构建请求
        Request request = new Request.Builder()
                .url("https://api.github.com/search/repositories?q=language:java&page=1")
                .get()
                .header("123", "321")
                .build();
        //发送请求
        //httpClient.newCall(request).execute()  同步请求
        httpClient.newCall(request).enqueue(new Callback() {
            //失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("TAG","请求失败了！");
            }
            //成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("TAG","响应数据：头："+response.header("123")+"响应体"+response.body().string());
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
