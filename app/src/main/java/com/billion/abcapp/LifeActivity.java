package com.billion.abcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.gyf.immersionbar.ImmersionBar;

public class LifeActivity extends AppCompatActivity implements View.OnClickListener {
    Activity mContext;
    Toolbar myToolbar;
    ImageView life_location_image;
    ImageView life_search_image;
    ImageView life_search_voice;
    ImageView life_order_image;
    TextView life_location_text;
    TextView life_search_text;
    TextView life_order_text;
    LinearLayout life_search_layout;
    LinearLayout life_below_main;
    LinearLayout life_below_money;
    LinearLayout life_below_life;
    TextView life_below_life_text;
    LinearLayout life_below_farmer;
    LinearLayout life_below_my;
    ImageView life_immersion_image;
    LinearLayout life_content_ly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        mContext = this;
        life_location_image = findViewById(R.id.life_location_image);
        life_search_image = findViewById(R.id.life_search_image);
        life_search_voice = findViewById(R.id.life_search_voice);
        life_order_image = findViewById(R.id.life_order_image);
        life_location_text = findViewById(R.id.life_location_text);
        life_search_text = findViewById(R.id.life_search_text);
        life_order_text = findViewById(R.id.life_order_text);
        life_search_layout = findViewById(R.id.life_search_layout);
        life_below_main = findViewById(R.id.life_below_main);
        life_below_money = findViewById(R.id.life_below_money);
        life_below_life = findViewById(R.id.life_below_life);
        life_below_life_text = findViewById(R.id.life_below_life_text);
        life_below_farmer = findViewById(R.id.life_below_farmer);
        life_below_my = findViewById(R.id.life_below_my);
        life_immersion_image = findViewById(R.id.life_immersion_image);
        life_content_ly = findViewById(R.id.life_content_ly);

        // 设置标题栏
        myToolbar = findViewById(R.id.life_toolbar);
        setSupportActionBar(myToolbar);

        // 沉浸式
        ImmersionBar.with(this).titleBar(myToolbar).barAlpha(0).init();

        // 滚动切换状态栏颜色
        NestedScrollView nestedScrollView = findViewById(R.id.life_nestedScrollView);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY <= 320) {
                    myToolbar.setBackgroundColor(getResources().getColor(R.color.toolkit_solid_alpha));
                    ImmersionBar.with(mContext).statusBarDarkFont(false).init();
                    life_location_image.setImageDrawable(getResources().getDrawable(R.drawable.life_location_white));
                    life_search_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_search_white));
                    life_search_voice.setImageDrawable(getResources().getDrawable(R.drawable.hp_voice_white));
                    life_order_image.setImageDrawable(getResources().getDrawable(R.drawable.life_order_white));
                    life_location_text.setTextColor(getResources().getColor(R.color.toolkit_solid));
                    life_search_text.setTextColor(getResources().getColor(R.color.toolkit_solid));
                    life_order_text.setTextColor(getResources().getColor(R.color.toolkit_solid));
                    life_search_layout.setBackground(getResources().getDrawable(R.drawable.hp_toolbar_white));
                }else {
                    myToolbar.setBackgroundColor(getResources().getColor(R.color.toolkit_solid));
                    ImmersionBar.with(mContext).statusBarDarkFont(true).init();
                    life_location_image.setImageDrawable(getResources().getDrawable(R.drawable.life_location_black));
                    life_search_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_search_black));
                    life_search_voice.setImageDrawable(getResources().getDrawable(R.drawable.hp_voice_black));
                    life_order_image.setImageDrawable(getResources().getDrawable(R.drawable.life_order_black));
                    life_location_text.setTextColor(getResources().getColor(R.color.black));
                    life_search_text.setTextColor(getResources().getColor(R.color.black));
                    life_order_text.setTextColor(getResources().getColor(R.color.black));
                    life_search_layout.setBackground(getResources().getDrawable(R.drawable.hp_toolbar_black));
                }
            }
        });

        // 设置底部导航文本加粗
        life_below_life_text.getPaint().setFakeBoldText(true);

        // 设置点击事件
        life_below_main.setOnClickListener(this);
        life_below_money.setOnClickListener(this);
        life_below_life.setOnClickListener(this);
        life_below_farmer.setOnClickListener(this);
        life_below_my.setOnClickListener(this);
        life_immersion_image.setOnClickListener(this);
        life_content_ly.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.life_below_main:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.life_below_money:
                startActivity(new Intent(this, MoneyActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.life_below_life:
                break;
            case R.id.life_below_farmer:
                startActivity(new Intent(this, FarmerActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.life_below_my:
                startActivity(new Intent(this, MyActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.life_immersion_image:
            case R.id.life_content_ly:
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