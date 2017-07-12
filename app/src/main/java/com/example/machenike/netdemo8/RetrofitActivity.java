package com.example.machenike.netdemo8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    @BindView(R.id.btn_get)
    Button mBtnGet;
    @BindView(R.id.btn_post)
    Button mBtnPost;
    @BindView(R.id.btn_form)
    Button mBtnForm;
    @BindView(R.id.btn_part)
    Button mBtnPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get)
    public void get() {
        RetrofitNetClient.getInstance().getRetrofitApi().getRetrofit("search").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //运行在主线程中，可以直接更新UI
                if (response.isSuccessful()) {
                    Toast.makeText(RetrofitActivity.this, "成功了", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RetrofitActivity.this, response.code() + "", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "失败了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_post)
    public void post() {
        RequestBody requestBody = RequestBody.create(null, "{\n" +
                "\"Password\":\"654321\"\n" +
                "\"UserName\":\"qjd\",\n" +
                "}");
        RetrofitNetClient.getInstance().getRetrofitApi().postRetrofit(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RetrofitActivity.this, "成功了" + response.code(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "失败了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_form)
    public void form() {
        RetrofitNetClient.getInstance().getRetrofitApi().formRetrofit("张三", "123").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RetrofitActivity.this, "成功了" + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_part)
    public void multiPart() {
        RequestBody requestBody = RequestBody.create(null, "{\n" +
                "\"name\": \"yt59856b15cf394e7b84a7d48447d16098\",\n" +
                "\"username\": \"xc62\",\n" +
                "\"nickname\": \"555\",\n" +
                "\"password\": \"123456\",\n" +
                "\"uuid\": \"0F8EC12223174657B2E842076D54C361\"\n" +
                "}");
        RetrofitNetClient.getInstance().getRetrofitApi().multiRetrofit(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RetrofitActivity.this, "成功了" + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
