package com.billion.abcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Activity mContext;
    private SharedPreferencesHelper spHelper;
    private RequestQueue mQueue;
    private EditText phone_num;
    private EditText user_name;
    private EditText validate_code;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        spHelper = new SharedPreferencesHelper(mContext);
        mQueue = Volley.newRequestQueue(mContext);
        phone_num = findViewById(R.id.phone_num);
        user_name = findViewById(R.id.user_name);
        validate_code = findViewById(R.id.validate_code);
        register = findViewById(R.id.register);

        // 设置状态栏前景和背景颜色
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.white).statusBarDarkFont(true).init();

        // 设置点击事件
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNum = String.valueOf(phone_num.getText());
                String userName = String.valueOf(user_name.getText());
                String validateCode = String.valueOf(validate_code.getText());
                // 发送网络请求判断账号是否过期
                JSONObject jsonRequest = new JSONObject();
                try {
                    jsonRequest.put("phoneNum", phoneNum);
                    jsonRequest.put("userName", userName);
                    jsonRequest.put("code", validateCode);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String baseUrl = "http://" + GlobalConfig.hostIp + ":" + GlobalConfig.port;
                String uri = "/api/user/register";
                JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(baseUrl + uri, jsonRequest,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Gson gson = new Gson();
                                CommonResult commonResult1 = gson.fromJson(response.toString(), CommonResult.class);
                                Toast.makeText(mContext, commonResult1.getComment(), Toast.LENGTH_SHORT).show();
                                if(commonResult1.getCode() == 0) {
                                    // 注册成功，保存信息并跳转
                                    User user = gson.fromJson(gson.toJson(commonResult1.getData()), User.class);
                                    spHelper.save(user);
                                    startActivity(new Intent(mContext, MainActivity.class));
                                    overridePendingTransition(0,0);
                                }
                            }},
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("TAG", error.getMessage(), error);
                            }
                        });
                jsonObjectRequest1.setRetryPolicy(new DefaultRetryPolicy(25 * 1000, 0, 1.0f));
                mQueue.add(jsonObjectRequest1);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View view) {
        // TODO
    }
}