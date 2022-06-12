package com.billion.abcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gyf.immersionbar.ImmersionBar;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoneyActivity extends AppCompatActivity implements View.OnClickListener{
    Activity mContext;
    Toolbar myToolbar;
    TextView money_hide;
    LinearLayout money_below_main;
    LinearLayout money_below_money;
    TextView money_below_money_text;
    LinearLayout money_below_life;
    LinearLayout money_below_farmer;
    LinearLayout money_below_my;
    TextView money_credit_text;
    TextView money_credit_money;
    TextView money_credit_time;
    TextView money_credit_yestoday_text;
    TextView money_credit_yestoday_money;
    LinearLayout money_ly_toolbar;
    LinearLayout money_content_ly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        mContext = this;
        money_hide = findViewById(R.id.money_hide);
        money_below_main = findViewById(R.id.money_below_main);
        money_below_money = findViewById(R.id.money_below_money);
        money_below_money_text = findViewById(R.id.money_below_money_text);
        money_below_life = findViewById(R.id.money_below_life);
        money_below_farmer = findViewById(R.id.money_below_farmer);
        money_below_my = findViewById(R.id.money_below_my);
        money_credit_text = findViewById(R.id.money_credit_text);
        money_credit_money = findViewById(R.id.money_credit_money);
        money_credit_time = findViewById(R.id.money_credit_time);
        money_credit_yestoday_text = findViewById(R.id.money_credit_yestoday_text);
        money_credit_yestoday_money = findViewById(R.id.money_credit_yestoday_money);
        money_ly_toolbar = findViewById(R.id.money_ly_toolbar);
        money_content_ly = findViewById(R.id.money_content_ly);


        // 设置标题栏
        myToolbar = findViewById(R.id.money_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setBackgroundColor(getResources().getColor(R.color.toolkit_solid));
        ImmersionBar.with(mContext).statusBarDarkFont(true).titleBar(myToolbar).init();

        // 设置隐藏控件的高度
        int height = ImmersionBar.getStatusBarHeight(this) * 2 + ImmersionBar.getActionBarHeight(this);
        money_hide.setHeight(height);

        // 设置底部导航文本加粗
        money_below_money_text.getPaint().setFakeBoldText(true);

        // 设置持仓文本加粗和时间文本
        money_credit_text.getPaint().setFakeBoldText(true);
        money_credit_money.getPaint().setFakeBoldText(true);
        money_credit_yestoday_text.getPaint().setFakeBoldText(true);
        money_credit_yestoday_money.getPaint().setFakeBoldText(true);
        SimpleDateFormat sdfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        money_credit_time.setText("数据截止 " + sdfdt.format(new Date()));

        // 设置广告轮播图1
        Banner<DataBean, ImageBannerAdapter> banner1 = findViewById(R.id.money_banner1);
        List<DataBean> mdatas1 = new ArrayList<>();
        mdatas1.add(new DataBean(R.drawable.money_banner1_1));
        mdatas1.add(new DataBean(R.drawable.money_banner1_2));
        banner1.setAdapter(new ImageBannerAdapter(mdatas1))
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this))
                .setIndicatorMargins(new IndicatorConfig.Margins(10, 0, 10, 5))
                .setLoopTime(2000);

        // 设置广告轮播图2
        Banner<DataBean, ImageBannerAdapter> banner2 = findViewById(R.id.money_banner2);
        List<DataBean> mdatas2 = new ArrayList<>();
        mdatas2.add(new DataBean(R.drawable.money_banner2_2));
        mdatas2.add(new DataBean(R.drawable.money_banner2_1));
        banner2.setAdapter(new ImageBannerAdapter(mdatas2))
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this))
                .setIndicatorMargins(new IndicatorConfig.Margins(10, 0, 10, 5))
                .setLoopTime(2000);

        // 设置点击事件
        money_below_main.setOnClickListener(this);
        money_below_money.setOnClickListener(this);
        money_below_life.setOnClickListener(this);
        money_below_farmer.setOnClickListener(this);
        money_below_my.setOnClickListener(this);
        money_ly_toolbar.setOnClickListener(this);
        money_content_ly.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.money_below_main:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.money_below_money:
                break;
            case R.id.money_below_life:
                startActivity(new Intent(this, LifeActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.money_below_farmer:
                startActivity(new Intent(this, FarmerActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.money_below_my:
                startActivity(new Intent(this, MyActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.money_ly_toolbar:
            case R.id.money_content_ly:
                Toast.makeText(mContext, "当前网络有问题，请稍后再试～", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}