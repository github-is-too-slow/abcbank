package com.billion.abcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.gyf.immersionbar.ImmersionBar;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyActivity extends AppCompatActivity implements View.OnClickListener{
    Activity mContext;
    RequestQueue mQueue;
    Toolbar myToolbar;
    TextView my_hide;
    LinearLayout my_below_main;
    LinearLayout my_below_money;
    LinearLayout my_below_life;
    LinearLayout my_below_farmer;
    LinearLayout my_below_my;
    TextView my_below_my_text;
    ImageView my_order_img;
    TextView my_bean_text;
    TextView my_score_text;
    TextView my_paper_text;
    TextView my_order_text;
    TextView my_center_login_text;
    TextView my_center_trans_text;
    TextView my_center_pay_text;
    TextView my_center_phone_text;
    TextView my_appoint_service_text;
    TextView my_appoint_fill_text;
    TextView my_appoint_cardless_text;
    TextView my_appoint_search_text;
    LinearLayout my_toolbar_ly;
    LinearLayout my_content_ly;
    TextView my_user_name;
    TextView my_last_login_time;
    TextView money_credit_money;
    TextView money_credit_time;
    TextView money_outcome;
    TextView money_income;
    TextView money_month_tip;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    money_credit_money.setText((double) msg.obj + "");
                    break;
                case 1:
                    double[] money = (double[]) msg.obj;
                    money_outcome.setText(money[0] + "");
                    money_income.setText(money[1] + "");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mContext = this;
        mQueue = Volley.newRequestQueue(mContext);
        my_hide = findViewById(R.id.my_hide);
        my_below_main = findViewById(R.id.my_below_main);
        my_below_money = findViewById(R.id.my_below_money);
        my_below_my_text = findViewById(R.id.my_below_my_text);
        my_below_life = findViewById(R.id.my_below_life);
        my_below_farmer = findViewById(R.id.my_below_farmer);
        my_below_my = findViewById(R.id.my_below_my);
        my_order_img = findViewById(R.id.my_order_img);
        my_bean_text = findViewById(R.id.my_bean_text);
        my_score_text = findViewById(R.id.my_score_text);
        my_paper_text = findViewById(R.id.my_paper_text);
        my_order_text = findViewById(R.id.my_order_text);
        my_center_login_text = findViewById(R.id.my_center_login_text);
        my_center_trans_text = findViewById(R.id.my_center_trans_text);
        my_center_pay_text = findViewById(R.id.my_center_pay_text);
        my_center_phone_text = findViewById(R.id.my_center_phone_text);
        my_appoint_service_text = findViewById(R.id.my_appoint_service_text);
        my_appoint_fill_text = findViewById(R.id.my_appoint_fill_text);
        my_appoint_cardless_text = findViewById(R.id.my_appoint_cardless_text);
        my_appoint_search_text = findViewById(R.id.my_appoint_search_text);
        my_toolbar_ly = findViewById(R.id.my_toolbar_ly);
        my_content_ly = findViewById(R.id.my_content_ly);
        my_user_name = findViewById(R.id.my_user_name);
        my_last_login_time = findViewById(R.id.my_last_login_time);
        money_credit_money = findViewById(R.id.money_credit_money);
        money_credit_time = findViewById(R.id.money_credit_time);
        money_outcome = findViewById(R.id.money_outcome);
        money_income = findViewById(R.id.money_income);
        money_month_tip = findViewById(R.id.money_month_tip);

        // 设置标题栏
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setBackgroundColor(getResources().getColor(R.color.toolkit_solid));
        ImmersionBar.with(mContext).statusBarDarkFont(true).titleBar(myToolbar).init();

        // 设置隐藏控件的高度
        int height = ImmersionBar.getStatusBarHeight(this) * 2 + ImmersionBar.getActionBarHeight(this);
        my_hide.setHeight(height);

        // 设置文本加粗
        my_below_my_text.getPaint().setFakeBoldText(true);
        my_bean_text.getPaint().setFakeBoldText(true);
        my_score_text.getPaint().setFakeBoldText(true);
        my_paper_text.getPaint().setFakeBoldText(true);
        my_order_text.getPaint().setFakeBoldText(true);
        my_center_login_text.getPaint().setFakeBoldText(true);
        my_center_trans_text.getPaint().setFakeBoldText(true);
        my_center_pay_text.getPaint().setFakeBoldText(true);
        my_center_phone_text.getPaint().setFakeBoldText(true);
        my_appoint_service_text.getPaint().setFakeBoldText(true);
        my_appoint_fill_text.getPaint().setFakeBoldText(true);
        my_appoint_cardless_text.getPaint().setFakeBoldText(true);
        my_appoint_search_text.getPaint().setFakeBoldText(true);

        // 设置用户名
        SharedPreferencesHelper spHelper = new SharedPreferencesHelper(this);
        User user = spHelper.read();
        String userName = user.getUserName();
        String userNameShow;
        int n = userName.length();
        if(n == 1) {
            userNameShow = "*" + userName;
        }else if(n == 2) {
            userNameShow = "*" + userName.substring(1);
        }else {
            userNameShow = "*" + userName.substring(n - 2);
        }
        my_user_name.setText(userNameShow);

        // 设置当前资产
        String baseUrl = "http://" + GlobalConfig.hostIp + ":" + GlobalConfig.port;
        String uri = "/api/detailsSearch/searchLeftMoney?userId=" +  + user.getUserId() + "&endTime=" + new Date().getTime();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( baseUrl + uri, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                        CommonResult commonResult = gson.fromJson(response.toString(), CommonResult.class);
                        if(commonResult.getCode() == 0) {
                            Message msg = Message.obtain();
                            msg.what = 0;
                            msg.obj = commonResult.getData();
                            mHandler.sendMessage(msg);
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

        // 设置本月支出
        baseUrl = "http://" + GlobalConfig.hostIp + ":" + GlobalConfig.port;
        uri = "/api/detailsSearch/getIncomeAndOutcome?userId=" +  + user.getUserId() + "&month=" + new Date().getMonth();
        jsonObjectRequest = new JsonObjectRequest( baseUrl + uri, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                        CommonResult commonResult = gson.fromJson(response.toString(), CommonResult.class);
                        if(commonResult.getCode() == 0) {
                            Message msg = Message.obtain();
                            msg.what = 1;
                            msg.obj = gson.fromJson(gson.toJson(commonResult.getData()), double[].class);
                            mHandler.sendMessage(msg);
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

        // 设置时间
        SimpleDateFormat sdfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        my_last_login_time.setText("上次登录 " + sdfdt.format(new Date()));
        money_credit_time.setText("数据截止 " + sdfdt.format(new Date()));
        money_month_tip.setText("您的" + new Date().getMonth() + "月份账单已出");

        // 设置点击事件
        my_below_main.setOnClickListener(this);
        my_below_money.setOnClickListener(this);
        my_below_life.setOnClickListener(this);
        my_below_farmer.setOnClickListener(this);
        my_below_my.setOnClickListener(this);
        my_toolbar_ly.setOnClickListener(this);
        my_content_ly.setOnClickListener(this);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_below_main:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.my_below_money:
                startActivity(new Intent(this, MoneyActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.my_below_life:
                startActivity(new Intent(this, LifeActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.my_below_farmer:
                startActivity(new Intent(this, FarmerActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.my_below_my:
                break;
            case R.id.my_toolbar_ly:
            case R.id.my_content_ly:
                Toast.makeText(mContext, "当前网络有问题，请稍后再试～", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}