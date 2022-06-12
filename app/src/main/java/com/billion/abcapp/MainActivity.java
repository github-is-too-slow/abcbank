package com.billion.abcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Timer timer;
    Activity mContext;
    Toolbar myToolbar;
    LinearLayout hp_ly_toolbar;
    ImageView hp_sign_image;
    ImageView hp_search_image;
    ImageView hp_search_voice;
    ImageView hp_switch_image;
    ImageView hp_kefu_image;
    ImageView hp_msg_image;
    TextView hp_sign_text;
    TextView hp_search_text;
    TextView hp_switch_text;
    TextView hp_kefu_text;
    TextView hp_msg_text;
    LinearLayout hp_search_layout;

    ImageView hp_immersion_image;
    LinearLayout hp_my_account;
    LinearLayout hp_transfer_money;
    LinearLayout hp_details_search;
    LinearLayout hp_scan_code;

    LinearLayout hp_credit_card;
    LinearLayout hp_save_money;
    LinearLayout hp_income_detail;
    LinearLayout hp_bean_farmer;
    LinearLayout hp_life_pay;
    LinearLayout hp_loan;
    LinearLayout hp_phone_recharge;
    LinearLayout hp_fund;
    LinearLayout hp_city_zone;
    LinearLayout hp_more;

    LinearLayout hp_toutiao_ly;
    LinearLayout hp_banner_ly;
    TextView hp_tip_pay;
    TextView hp_tip_return;
    TextView hp_tip_person;
    ImageView hp_go_set;
    LinearLayout hp_recommend_ly1;
    LinearLayout hp_recommend_ly2;
    LinearLayout hp_recommend_ly3;
    LinearLayout hp_recommend_ly4;
    LinearLayout hp_recommend_ly5;
    LinearLayout hp_recommend_ly6;
    LinearLayout hp_fund_ly1;
    LinearLayout hp_fund_ly2;
    LinearLayout hp_fund_ly3;
    ImageView hp_activity_1_1;
    ImageView hp_activity_1_2;
    ImageView hp_activity_1_3;
    ImageView hp_activity_1_4;
    ImageView hp_activity_1_5;
    ImageView hp_activity_2_1;
    ImageView hp_activity_2_2;
    ImageView hp_activity_2_3;
    ImageView hp_activity_2_4;
    ImageView hp_activity_2_5;
    ImageView hp_farmer_market;
    LinearLayout hp_hot_news1;
    LinearLayout hp_hot_news2;
    LinearLayout hp_hot_news3;
    LinearLayout hp_hot_news4;
    LinearLayout hp_hot_news5;
    TextView hp_slide_text;
    TextView hp_hide_component;

    LinearLayout hp_below_main;
    TextView hp_below_main_text;
    LinearLayout hp_below_money;
    LinearLayout hp_below_life;
    LinearLayout hp_below_farmer;
    LinearLayout hp_below_my;

    // 标识是否滑动到顶部
    private boolean isScrollToStart = false;
    // 标识是否滑动到底部
    private boolean isScrollToEnd = false;
    private static final int CODE_TO_START = 0x001;
    private static final int CODE_TO_END = 0x002;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case CODE_TO_START:
                    //重置标志“滑动到顶部”时的标志位
                    isScrollToStart = false;
                    break;
                case CODE_TO_END:
                    //重置标志“滑动到底部”时的标志位
                    isScrollToEnd = false;
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        mContext = this;
        hp_ly_toolbar = findViewById(R.id.hp_ly_toolbar);
        hp_sign_image = findViewById(R.id.hp_sign_image);
        hp_search_image = findViewById(R.id.hp_search_image);
        hp_search_voice = findViewById(R.id.hp_search_voice);
        hp_switch_image = findViewById(R.id.hp_switch_image);
        hp_kefu_image = findViewById(R.id.hp_kefu_image);
        hp_msg_image = findViewById(R.id.hp_msg_image);
        hp_sign_text = findViewById(R.id.hp_sign_text);
        hp_search_text = findViewById(R.id.hp_search_text);
        hp_switch_text = findViewById(R.id.hp_switch_text);
        hp_kefu_text = findViewById(R.id.hp_kefu_text);
        hp_msg_text = findViewById(R.id.hp_msg_text);
        hp_search_layout = findViewById(R.id.hp_search_layout);

        hp_immersion_image = findViewById(R.id.hp_immersion_image);
        hp_my_account = findViewById(R.id.hp_my_account);
        hp_transfer_money = findViewById(R.id.hp_transfer_money);
        hp_details_search = findViewById(R.id.hp_details_search);
        hp_scan_code = findViewById(R.id.hp_scan_code);

        hp_credit_card = findViewById(R.id.hp_credit_card);
        hp_save_money = findViewById(R.id.hp_save_money);
        hp_income_detail = findViewById(R.id.hp_income_detail);
        hp_bean_farmer = findViewById(R.id.hp_bean_farmer);
        hp_life_pay = findViewById(R.id.hp_life_pay);
        hp_loan = findViewById(R.id.hp_loan);
        hp_phone_recharge = findViewById(R.id.hp_phone_recharge);
        hp_fund = findViewById(R.id.hp_fund);
        hp_city_zone = findViewById(R.id.hp_city_zone);
        hp_more = findViewById(R.id.hp_more);

        hp_toutiao_ly = findViewById(R.id.hp_toutiao_ly);
        hp_banner_ly = findViewById(R.id.hp_banner_ly);
        hp_tip_pay = findViewById(R.id.hp_tip_pay);
        hp_tip_return = findViewById(R.id.hp_tip_return);
        hp_tip_person = findViewById(R.id.hp_tip_person);
        hp_go_set = findViewById(R.id.hp_go_set);
        hp_recommend_ly1 = findViewById(R.id.hp_recommend_ly1);
        hp_recommend_ly2 = findViewById(R.id.hp_recommend_ly2);
        hp_recommend_ly3 = findViewById(R.id.hp_recommend_ly3);
        hp_recommend_ly4 = findViewById(R.id.hp_recommend_ly4);
        hp_recommend_ly5 = findViewById(R.id.hp_recommend_ly5);
        hp_recommend_ly6 = findViewById(R.id.hp_recommend_ly6);
        hp_fund_ly1 = findViewById(R.id.hp_fund_ly1);
        hp_fund_ly2 = findViewById(R.id.hp_fund_ly2);
        hp_fund_ly3 = findViewById(R.id.hp_fund_ly3);
        hp_activity_1_1 = findViewById(R.id.hp_activity_1_1);
        hp_activity_1_2 = findViewById(R.id.hp_activity_1_2);
        hp_activity_1_3 = findViewById(R.id.hp_activity_1_3);
        hp_activity_1_4 = findViewById(R.id.hp_activity_1_4);
        hp_activity_1_5 = findViewById(R.id.hp_activity_1_5);
        hp_activity_2_1 = findViewById(R.id.hp_activity_2_1);
        hp_activity_2_2 = findViewById(R.id.hp_activity_2_2);
        hp_activity_2_3 = findViewById(R.id.hp_activity_2_3);
        hp_activity_2_4 = findViewById(R.id.hp_activity_2_4);
        hp_activity_2_5 = findViewById(R.id.hp_activity_2_5);
        hp_farmer_market = findViewById(R.id.hp_farmer_market);
        hp_hot_news1 = findViewById(R.id.hp_hot_news1);
        hp_hot_news2 = findViewById(R.id.hp_hot_news2);
        hp_hot_news3 = findViewById(R.id.hp_hot_news3);
        hp_hot_news4 = findViewById(R.id.hp_hot_news4);
        hp_hot_news5 = findViewById(R.id.hp_hot_news5);

        hp_below_main = findViewById(R.id.hp_below_main);
        hp_below_main_text = findViewById(R.id.hp_below_main_text);
        hp_below_money = findViewById(R.id.hp_below_money);
        hp_below_life = findViewById(R.id.hp_below_life);
        hp_below_farmer = findViewById(R.id.hp_below_farmer);
        hp_below_my = findViewById(R.id.hp_below_my);
        hp_slide_text = findViewById(R.id.hp_slide_text);
        hp_hide_component = findViewById(R.id.hp_hide_component);

        // 设置标题栏
        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // 沉浸式
        ImmersionBar.with(this).titleBar(myToolbar).barAlpha(0).init();

        // 滚动切换状态栏颜色
        NestedScrollView nestedScrollView = findViewById(R.id.hp_nestedScrollView);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY <= 320) {
                    myToolbar.setBackgroundColor(getResources().getColor(R.color.toolkit_solid_alpha));
                    ImmersionBar.with(mContext).statusBarDarkFont(false).init();
                    hp_sign_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_sign_white));
                    hp_search_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_search_white));
                    hp_search_voice.setImageDrawable(getResources().getDrawable(R.drawable.hp_voice_white));
                    hp_switch_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_switch_white));
                    hp_kefu_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_kefu_white));
                    hp_msg_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_msg_white));
                    hp_sign_text.setTextColor(getResources().getColor(R.color.toolkit_solid));
                    hp_search_text.setTextColor(getResources().getColor(R.color.toolkit_solid));
                    hp_switch_text.setTextColor(getResources().getColor(R.color.toolkit_solid));
                    hp_kefu_text.setTextColor(getResources().getColor(R.color.toolkit_solid));
                    hp_msg_text.setTextColor(getResources().getColor(R.color.toolkit_solid));
                    hp_search_layout.setBackground(getResources().getDrawable(R.drawable.hp_toolbar_white));
                }else {
                    myToolbar.setBackgroundColor(getResources().getColor(R.color.toolkit_solid));
                    ImmersionBar.with(mContext).statusBarDarkFont(true).init();
                    hp_sign_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_sign_black));
                    hp_search_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_search_black));
                    hp_search_voice.setImageDrawable(getResources().getDrawable(R.drawable.hp_voice_black));
                    hp_switch_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_switch_black));
                    hp_kefu_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_kefu_black));
                    hp_msg_image.setImageDrawable(getResources().getDrawable(R.drawable.hp_msg_black));
                    hp_sign_text.setTextColor(getResources().getColor(R.color.black));
                    hp_search_text.setTextColor(getResources().getColor(R.color.black));
                    hp_switch_text.setTextColor(getResources().getColor(R.color.black));
                    hp_kefu_text.setTextColor(getResources().getColor(R.color.black));
                    hp_msg_text.setTextColor(getResources().getColor(R.color.black));
                    hp_search_layout.setBackground(getResources().getDrawable(R.drawable.hp_toolbar_black));
                }
                View contentView = v.getChildAt(0);
                if (contentView != null && contentView.getMeasuredHeight() == (v.getScrollY() + v.getHeight())) {
                    // 滚动到底部，ScrollView存在回弹效果效应
                    //优化，只过滤第一次
                    if (!isScrollToEnd) {
                        isScrollToEnd = true;
                        mHandler.sendEmptyMessageDelayed(CODE_TO_END, 200);
                        hp_slide_text.setText("松开查看更多理财信息");
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(mContext, MoneyActivity.class));
                                overridePendingTransition(0, 0);
                            }
                        }, 1000);
                    }
                }else {
                    hp_slide_text.setText("上滑查看更多理财信息");
                    mHandler.removeCallbacksAndMessages(null);
                }
            }
        });

        // 设置底部导航文本加粗
        hp_below_main_text.getPaint().setFakeBoldText(true);

        // 设置垂直滚动头条栏
        MarqueeView textOfToutiao = findViewById(R.id.toutiao_text);
        List<String> messages = new ArrayList<>();
        messages.add("摩根大楼资管CEO：虎年市场八面来风");
        messages.add("中国农业银行服务价格标准（2022）");
        messages.add("关于发布《中国农业银行服务收费价格目录》的公告");
        textOfToutiao.startWithList(messages);

        // 设置广告轮播图
        Banner<DataBean, ImageBannerAdapter> banner = findViewById(R.id.hp_banner);
        List<DataBean> mdatas = new ArrayList<>();
        mdatas.add(new DataBean(R.drawable.hp_banner1_200));
        mdatas.add(new DataBean(R.drawable.hp_banner2_200));
        mdatas.add(new DataBean(R.drawable.hp_banner3_200));
        banner.setAdapter(new ImageBannerAdapter(mdatas))
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this))
                .setIndicatorMargins(new IndicatorConfig.Margins(10, 0, 10, 0))
                .setLoopTime(2000);

        // 新闻栏相关设置
        // 1. 新闻时间设置
        TextView tv_hp_news_time1 = findViewById(R.id.tv_hp_news_time1);
        TextView tv_hp_news_time2 = findViewById(R.id.tv_hp_news_time2);
        TextView tv_hp_news_time3 = findViewById(R.id.tv_hp_news_time3);
        TextView tv_hp_news_time4 = findViewById(R.id.tv_hp_news_time4);
        TextView tv_hp_news_time5 = findViewById(R.id.tv_hp_news_time5);
        Date date = new Date(System.currentTimeMillis() - 3 * 24 * 3600 * 1000);
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Log.e("hp", dateFormat.format(date));
        tv_hp_news_time1.setText(dateFormat.format(date));
        tv_hp_news_time2.setText(dateFormat.format(date));
        tv_hp_news_time3.setText(dateFormat.format(date));
        tv_hp_news_time4.setText(dateFormat.format(date));
        tv_hp_news_time5.setText(dateFormat.format(date));
        // 2. 新闻缩略图圆角设置
        ImageView iv_hp_news1 = findViewById(R.id.iv_hp_news1);
        ImageView iv_hp_news2 = findViewById(R.id.iv_hp_news2);
        ImageView iv_hp_news3 = findViewById(R.id.iv_hp_news3);
        ImageView iv_hp_news4 = findViewById(R.id.iv_hp_news4);
        ImageView iv_hp_news5 = findViewById(R.id.iv_hp_news5);
        Uri uri_hp_news_1 = Uri.parse("android.resource://com.billion.abcapp/" + R.drawable.hp_news_1);
        Uri uri_hp_news_2 = Uri.parse("android.resource://com.billion.abcapp/" + R.drawable.hp_news_2);
        Uri uri_hp_news_3 = Uri.parse("android.resource://com.billion.abcapp/" + R.drawable.hp_news_3);
        Uri uri_hp_news_4 = Uri.parse("android.resource://com.billion.abcapp/" + R.drawable.hp_news_4);
        Uri uri_hp_news_5 = Uri.parse("android.resource://com.billion.abcapp/" + R.drawable.hp_news_5);
        // 图片圆角为15
        RequestOptions options = new RequestOptions().bitmapTransform(new RoundedCorners(15));
        Glide.with(this).load(uri_hp_news_1).apply(options).into(iv_hp_news1);
        Glide.with(this).load(uri_hp_news_2).apply(options).into(iv_hp_news2);
        Glide.with(this).load(uri_hp_news_3).apply(options).into(iv_hp_news3);
        Glide.with(this).load(uri_hp_news_4).apply(options).into(iv_hp_news4);
        Glide.with(this).load(uri_hp_news_5).apply(options).into(iv_hp_news5);

        // 设置点击事件
        hp_below_main.setOnClickListener(this);
        hp_below_money.setOnClickListener(this);
        hp_below_life.setOnClickListener(this);
        hp_below_farmer.setOnClickListener(this);
        hp_below_my.setOnClickListener(this);
        hp_ly_toolbar.setOnClickListener(this);
        hp_immersion_image.setOnClickListener(this);
        hp_my_account.setOnClickListener(this);
        hp_transfer_money.setOnClickListener(this);
        hp_details_search.setOnClickListener(this);
        hp_scan_code.setOnClickListener(this);
        hp_credit_card.setOnClickListener(this);
        hp_save_money.setOnClickListener(this);
        hp_income_detail.setOnClickListener(this);
        hp_bean_farmer.setOnClickListener(this);
        hp_life_pay.setOnClickListener(this);
        hp_loan.setOnClickListener(this);
        hp_phone_recharge.setOnClickListener(this);
        hp_fund.setOnClickListener(this);
        hp_city_zone.setOnClickListener(this);
        hp_more.setOnClickListener(this);
        hp_toutiao_ly.setOnClickListener(this);
        hp_banner_ly.setOnClickListener(this);
        hp_tip_pay.setOnClickListener(this);
        hp_tip_return.setOnClickListener(this);
        hp_tip_person.setOnClickListener(this);
        hp_go_set.setOnClickListener(this);
        hp_recommend_ly1.setOnClickListener(this);
        hp_recommend_ly2.setOnClickListener(this);
        hp_recommend_ly3.setOnClickListener(this);
        hp_recommend_ly4.setOnClickListener(this);
        hp_recommend_ly5.setOnClickListener(this);
        hp_recommend_ly6.setOnClickListener(this);
        hp_fund_ly1.setOnClickListener(this);
        hp_fund_ly2.setOnClickListener(this);
        hp_fund_ly3.setOnClickListener(this);
        hp_activity_1_1.setOnClickListener(this);
        hp_activity_1_2.setOnClickListener(this);
        hp_activity_1_3.setOnClickListener(this);
        hp_activity_1_4.setOnClickListener(this);
        hp_activity_1_5.setOnClickListener(this);
        hp_activity_2_1.setOnClickListener(this);
        hp_activity_2_2.setOnClickListener(this);
        hp_activity_2_3.setOnClickListener(this);
        hp_activity_2_4.setOnClickListener(this);
        hp_activity_2_5.setOnClickListener(this);
        hp_farmer_market.setOnClickListener(this);
        hp_hot_news1.setOnClickListener(this);
        hp_hot_news2.setOnClickListener(this);
        hp_hot_news3.setOnClickListener(this);
        hp_hot_news4.setOnClickListener(this);
        hp_hot_news5.setOnClickListener(this);
        hp_slide_text.setOnClickListener(this);
        hp_hide_component.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hp_below_main:
                break;
            case R.id.hp_below_money:
                startActivity(new Intent(this, MoneyActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.hp_below_life:
                startActivity(new Intent(this, LifeActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.hp_below_farmer:
                startActivity(new Intent(this, FarmerActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.hp_below_my:
                startActivity(new Intent(this, MyActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.hp_details_search:
                startActivity(new Intent(this, DetailsSearchActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.hp_ly_toolbar:
            case R.id.hp_immersion_image:
            case R.id.hp_my_account:
            case R.id.hp_transfer_money:
            case R.id.hp_scan_code:
            case R.id.hp_credit_card:
            case R.id.hp_save_money:
            case R.id.hp_income_detail:
            case R.id.hp_bean_farmer:
            case R.id.hp_life_pay:
            case R.id.hp_loan:
            case R.id.hp_phone_recharge:
            case R.id.hp_fund:
            case R.id.hp_city_zone:
            case R.id.hp_more:
            case R.id.hp_toutiao_ly:
            case R.id.hp_banner_ly:
            case R.id.hp_tip_pay:
            case R.id.hp_tip_return:
            case R.id.hp_tip_person:
            case R.id.hp_go_set:
            case R.id.hp_recommend_ly1:
            case R.id.hp_recommend_ly2:
            case R.id.hp_recommend_ly3:
            case R.id.hp_recommend_ly4:
            case R.id.hp_recommend_ly5:
            case R.id.hp_recommend_ly6:
            case R.id.hp_fund_ly1:
            case R.id.hp_fund_ly2:
            case R.id.hp_fund_ly3:
            case R.id.hp_activity_1_1:
            case R.id.hp_activity_1_2:
            case R.id.hp_activity_1_3:
            case R.id.hp_activity_1_4:
            case R.id.hp_activity_1_5:
            case R.id.hp_activity_2_1:
            case R.id.hp_activity_2_2:
            case R.id.hp_activity_2_3:
            case R.id.hp_activity_2_4:
            case R.id.hp_activity_2_5:
            case R.id.hp_farmer_market:
            case R.id.hp_hot_news1:
            case R.id.hp_hot_news2:
            case R.id.hp_hot_news3:
            case R.id.hp_hot_news4:
            case R.id.hp_hot_news5:
                Toast.makeText(mContext, "当前网络有问题，请稍后再试～", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}