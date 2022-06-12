package com.billion.abcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;

import org.json.JSONException;
import org.json.JSONObject;

public class StartActivity extends AppCompatActivity {
    private Activity mContext;
    private Handler mHandler;
    private SharedPreferencesHelper spHelper;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mContext = this;
        mHandler = new Handler();
        spHelper = new SharedPreferencesHelper(mContext);
        mQueue = Volley.newRequestQueue(mContext);
        ImmersionBar.with(this).fullScreen(true).init();
        User user = spHelper.read();
        if(user != null) {
            // 发送网络请求判断账号是否过期
            JSONObject jsonRequest = new JSONObject();
            try {
                jsonRequest.put("phoneNum", user.getPhoneNum());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String baseUrl = "http://" + GlobalConfig.hostIp + ":" + GlobalConfig.port;
            String uri = "/api/user/isLogin";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(baseUrl + uri, jsonRequest,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Gson gson = new Gson();
                            CommonResult commonResult = gson.fromJson(response.toString(), CommonResult.class);
                            if(commonResult.getCode() == 0) {
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mContext.startActivity(new Intent(mContext, MainActivity.class));
                                        mContext.finish();
                                    }
                                }, 2000);
                            } else {
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mContext.startActivity(new Intent(mContext, LoginActivity.class));
                                        mContext.finish();
                                    }
                                }, 2000);
                            }
                        }},
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG", error.getMessage(), error);
                        }
            });
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(25 * 1000, 0, 1.0f));
            mQueue.add(jsonObjectRequest);
        } else {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mContext.startActivity(new Intent(mContext, LoginActivity.class));
                    mContext.finish();
                }
            }, 3000);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}