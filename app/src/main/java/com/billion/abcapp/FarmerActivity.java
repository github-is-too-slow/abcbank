package com.billion.abcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gyf.immersionbar.ImmersionBar;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class FarmerActivity extends AppCompatActivity implements View.OnClickListener{
    Activity mContext;
    Toolbar myToolbar;
    TextView farmer_hide;
    LinearLayout farmer_below_main;
    LinearLayout farmer_below_money;
    LinearLayout farmer_below_life;
    LinearLayout farmer_below_farmer;
    TextView farmer_below_farmer_text;
    LinearLayout farmer_below_my;
    ImageView farmer_sale1;
    ImageView farmer_sale2;
    ImageView farmer_sale3;
    ImageView farmer_sale4;
    LinearLayout farmer_toolbar_ly;
    LinearLayout farmer_content_ly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        mContext = this;
        farmer_hide = findViewById(R.id.farmer_hide);
        farmer_below_main = findViewById(R.id.farmer_below_main);
        farmer_below_money = findViewById(R.id.farmer_below_money);
        farmer_below_life = findViewById(R.id.farmer_below_life);
        farmer_below_farmer = findViewById(R.id.farmer_below_farmer);
        farmer_below_farmer_text = findViewById(R.id.farmer_below_farmer_text);
        farmer_below_my = findViewById(R.id.farmer_below_my);
        farmer_sale1 = findViewById(R.id.farmer_sale1);
        farmer_sale2 = findViewById(R.id.farmer_sale2);
        farmer_sale3 = findViewById(R.id.farmer_sale3);
        farmer_sale4 = findViewById(R.id.farmer_sale4);
        farmer_toolbar_ly = findViewById(R.id.farmer_toolbar_ly);
        farmer_content_ly = findViewById(R.id.farmer_content_ly);

        // 设置标题栏
        myToolbar = findViewById(R.id.farmer_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setBackgroundColor(getResources().getColor(R.color.toolkit_solid));
        ImmersionBar.with(mContext).statusBarDarkFont(true).titleBar(myToolbar).init();

        // 设置隐藏控件的高度
        int height = ImmersionBar.getStatusBarHeight(this) * 2 + ImmersionBar.getActionBarHeight(this);
        farmer_hide.setHeight(height);

        // 设置底部导航文本加粗
        farmer_below_farmer_text.getPaint().setFakeBoldText(true);

        // 设置广告轮播图1
        Banner<DataBean, ImageBannerAdapter> banner = findViewById(R.id.farmer_banner);
        List<DataBean> mdatas = new ArrayList<>();
        mdatas.add(new DataBean(R.drawable.farmer_banner3));
        mdatas.add(new DataBean(R.drawable.farmer_banner4));
//        banner.setScaleX(banner.getX() /  686.0f);
//        banner.setScaleY(150 / 220.0f);
        banner.setAdapter(new ImageBannerAdapter(mdatas))
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this))
                .setIndicatorMargins(new IndicatorConfig.Margins(10, 0, 10, 5))
                .setLoopTime(2000);

        // 设置点击事件
        farmer_below_main.setOnClickListener(this);
        farmer_below_money.setOnClickListener(this);
        farmer_below_life.setOnClickListener(this);
        farmer_below_farmer.setOnClickListener(this);
        farmer_below_my.setOnClickListener(this);
        farmer_toolbar_ly.setOnClickListener(this);
        farmer_content_ly.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.farmer_below_main:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.farmer_below_money:
                startActivity(new Intent(this, MoneyActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.farmer_below_life:
                startActivity(new Intent(this, LifeActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.farmer_below_farmer:
                break;
            case R.id.farmer_below_my:
                startActivity(new Intent(this, MyActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.farmer_toolbar_ly:
            case R.id.farmer_content_ly:
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