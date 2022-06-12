package com.billion.abcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DetailsSearchActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    Activity mContext;
    Handler mHandler;
    private SharedPreferencesHelper spHelper;
    RequestQueue mQueue;
    ListView ds_list;
    ListViewAdapter mAdapter;
    List<DetailsSearchListItem> mData = new ArrayList<>();
    LinearLayout ds_filter_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_search);
        mContext = this;
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0) {
                    mAdapter.add((List<DetailsSearchListItem>) msg.obj);
                    mAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(mContext, "获取明细查询数据失败", Toast.LENGTH_SHORT).show();
                }
            }
        };
        spHelper = new SharedPreferencesHelper(mContext);
        mQueue = Volley.newRequestQueue(mContext);
        ds_list = findViewById(R.id.ds_list);
        ds_filter_layout = findViewById(R.id.ds_filter_layout);
        User user = spHelper.read();
        String baseUrl = "http://" + GlobalConfig.hostIp + ":" + GlobalConfig.port;
        String uri = "/api/detailsSearch/searchAllDetailsSearch?userId=" + user.getUserId();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(baseUrl + uri, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                        CommonResult commonResult = gson.fromJson(response.toString(), CommonResult.class);
                        System.out.println(commonResult.getData());
                        if(commonResult.getCode() == 0) {
                            Message msg = Message.obtain();
                            msg.what = 0;
                            msg.obj = gson.fromJson((String) commonResult.getData(), new TypeToken<List<DetailsSearchListItem>>() {}.getType());
                            mHandler.sendMessage(msg);
                        } else {
                            Message msg = Message.obtain();
                            msg.what = 1;
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
        mAdapter = new ListViewAdapter(mData, this);
        ds_list.addFooterView(LayoutInflater.from(this).inflate(R.layout.details_list_footer, null, false));
        ds_list.setAdapter(mAdapter);
        ds_list.setOnItemClickListener(this);
        // 设置状态栏前景和背景颜色
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.white).statusBarDarkFont(true).init();

        // 设置中文文本加粗

        // 设置点击事件
        ds_filter_layout.setOnClickListener(this);
        try {
            Thread.sleep(500);
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
        // TODO
        switch (view.getId()) {
            case R.id.ds_filter_layout:
                startActivityForResult(new Intent(this, DetailsSearchFilterActivity.class), 0);
                overridePendingTransition(R.anim.slid_left_in, R.anim.slid_right_out);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this, DetailsSearchDetailsActivity.class);
        intent.putExtra("detailsSearchListItem", new Gson().toJson(mData.get(position)));
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                System.out.println("成功返回");
        }
    }
}