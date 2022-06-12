package com.billion.abcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DetailsSearchFilterActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_OK = -1;
    public static final int RESULT_FIRST_USER = 1;
    Activity mContext;
    TextView filter_time_title;
    TextView filter_time_end;
    TextView filter_type_title;
    TextView filter_money_title;
    TextView filter_comment_title;
    TextView filter_from_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_search_filter);
        mContext = this;
        filter_time_title = findViewById(R.id.filter_time_title);
        filter_time_end = findViewById(R.id.filter_time_end);
        filter_type_title = findViewById(R.id.filter_type_title);
        filter_money_title = findViewById(R.id.filter_money_title);
        filter_comment_title = findViewById(R.id.filter_comment_title);
        filter_from_title = findViewById(R.id.filter_from_title);

        // 设置状态栏前景和背景颜色
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.white).statusBarDarkFont(true).init();

        // 初始化交易时间
        filter_time_end.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        // 设置中文文本加粗
        filter_time_title.getPaint().setFakeBoldText(true);
        filter_type_title.getPaint().setFakeBoldText(true);
        filter_money_title.getPaint().setFakeBoldText(true);
        filter_comment_title.getPaint().setFakeBoldText(true);
        filter_from_title.getPaint().setFakeBoldText(true);

        // 设置点击事件

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