package com.example.machenike.netdemo8;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by MACHENIKE on 2017/7/12.
 */

public abstract class UiCallback implements Callback{
    //后台线程
    //Handler运行在哪个线程取决于Looper是哪个线程里面的Looper
    //得到运行在主线程里面的Handler
    Handler mHandler = new Handler(Looper.getMainLooper());
    @Override
    public void onFailure(final Call call, final IOException e) {
        //后台线程
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //主线程
                onFailureInUi(call,e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //主线程
                try {
                    onResponseInUi(call,response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //运行在主线程的onResponse
    public abstract void onResponseInUi(Call call, Response response) throws IOException;
    //运行在主线程的onResponseonFailure
    public abstract void onFailureInUi(Call call, IOException e);

}
