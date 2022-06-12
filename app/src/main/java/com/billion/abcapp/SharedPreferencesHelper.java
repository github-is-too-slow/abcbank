package com.billion.abcapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.sql.Timestamp;
import java.util.List;

public class SharedPreferencesHelper {
    private Context mContext;

    public SharedPreferencesHelper() {
    }

    public SharedPreferencesHelper(Context mContext) {
        this.mContext = mContext;
    }


    //定义一个保存数据的方法
    public void save(User user) {
        SharedPreferences sp = mContext.getSharedPreferences("abc_bank_sp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("userId", user.getUserId());
        editor.putString("userName", user.getUserName());
        editor.putString("phoneNum", user.getPhoneNum());
        editor.putString("bankNum", user.getBankNum());
        editor.commit();
    }

    //定义一个读取SP文件的方法
    public User read() {
        SharedPreferences sp = mContext.getSharedPreferences("abc_bank_sp", Context.MODE_PRIVATE);
        if(sp.getString("phoneNum", null) == null)  return null;
        User user = new User();
        user.setUserId(sp.getLong("userId", 0));
        user.setUserName(sp.getString("userName", null));
        user.setPhoneNum(sp.getString("phoneNum", null));
        user.setBankNum(sp.getString("bankNum", null));
        return user;
    }

    //定义一个保存数据的方法
    public void saveDetailsItemList(String items) {
        SharedPreferences sp = mContext.getSharedPreferences("abc_bank_sp_details_item", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("items", items);
        editor.commit();
    }

    //定义一个读取SP文件的方法
    public List<DetailsSearchListItem> readDetailsItemList() {
        SharedPreferences sp = mContext.getSharedPreferences("abc_bank_sp_details_item", Context.MODE_PRIVATE);
        Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.fromJson(sp.getString("items", ""), new TypeToken<List<DetailsSearchListItem>>() {}.getType());
    }
}
