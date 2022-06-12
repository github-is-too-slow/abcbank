package com.billion.abcapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;

import java.text.SimpleDateFormat;


public class DetailsSearchDetailsActivity extends AppCompatActivity {
    Activity mContext;
    TextView ds_abc_number;
    TextView ds_details_transaction_money;
    TextView ds_details_transaction_time;
    TextView ds_details_transaction_comment;
    TextView ds_details_transaction_from_name;
    TextView ds_details_transaction_from_account;
    TextView ds_details_transaction_type;
    TextView ds_details_transaction_channel;
    TextView ds_details_left_money;
    TextView ds_details_attach_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_search_details);
        mContext = this;
        ds_abc_number = findViewById(R.id.ds_abc_number);
        ds_details_transaction_money = findViewById(R.id.ds_details_transaction_money);
        ds_details_transaction_time = findViewById(R.id.ds_details_transaction_time);
        ds_details_transaction_comment = findViewById(R.id.ds_details_transaction_comment);
        ds_details_transaction_from_name = findViewById(R.id.ds_details_transaction_from_name);
        ds_details_transaction_from_account = findViewById(R.id.ds_details_transaction_from_account);
        ds_details_transaction_type = findViewById(R.id.ds_details_transaction_type);
        ds_details_transaction_channel = findViewById(R.id.ds_details_transaction_channel);
        ds_details_left_money = findViewById(R.id.ds_details_left_money);
        ds_details_attach_comment = findViewById(R.id.ds_details_attach_comment);

        // 获取父activity传递的信息
        DetailsSearchListItem item = new Gson().fromJson(getIntent().getStringExtra("detailsSearchListItem"), DetailsSearchListItem.class);
        ds_abc_number.setText(item.getBankNum());
        double transactionMoney = item.getTransactionMoney();
        if(transactionMoney >= 0) {
            ds_details_transaction_money.setText("+" + String.valueOf(transactionMoney));
            ds_details_transaction_money.setTextColor(mContext.getResources().getColor(R.color.ds_details_money_text3));
        }else {
            ds_details_transaction_money.setText(String.valueOf(transactionMoney));
            ds_details_transaction_money.setTextColor(mContext.getResources().getColor(R.color.ds_details_money_text2));
        }
        SimpleDateFormat sdfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ds_details_transaction_time.setText(sdfdt.format(item.getTransactionTime()));
        ds_details_transaction_comment.setText(item.getTransactionComment());
        ds_details_transaction_from_name.setText(item.getFromName());
        ds_details_transaction_from_account.setText(item.getFromAccount());
        ds_details_transaction_type.setText(item.getTransactionType());
        ds_details_transaction_channel.setText(item.getTransactionChannel());
        ds_details_left_money.setText(String.valueOf(item.getLeftMoney()));
        ds_details_attach_comment.setText(item.getAttachComment());

        // 设置状态栏前景和背景颜色
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.white).statusBarDarkFont(true).init();

        // 设置中文文本加粗

        // 设置点击事件

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}