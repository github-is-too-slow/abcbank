package com.billion.abcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<DetailsSearchListItem> mData;

    public ListViewAdapter() {
    }

    public ListViewAdapter(List<DetailsSearchListItem> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.details_list_item, parent, false);
            holder = new ViewHolder();
            holder.ds_transaction_type = convertView.findViewById(R.id.ds_transaction_type);
            holder.ds_transaction_money = convertView.findViewById(R.id.ds_transaction_money);
            holder.ds_transaction_time = convertView.findViewById(R.id.ds_transaction_time);
            holder.ds_left_money = convertView.findViewById(R.id.ds_left_money);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ds_transaction_type.setText(mData.get(position).getTransactionComment());
        if(mData.get(position).getTransactionMoney() >= 0) {
            holder.ds_transaction_money.setText("+" + String.valueOf(mData.get(position).getTransactionMoney()));
            holder.ds_transaction_money.setTextColor(mContext.getResources().getColor(R.color.ds_item_type_positive));
        }else {
            holder.ds_transaction_money.setText(String.valueOf(mData.get(position).getTransactionMoney()));
            holder.ds_transaction_money.setTextColor(mContext.getResources().getColor(R.color.ds_item_type));
        }
        SimpleDateFormat sdfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        holder.ds_transaction_time.setText(sdfdt.format(mData.get(position).getTransactionTime()));
        holder.ds_left_money.setText("余额：" + String.valueOf(mData.get(position).getLeftMoney()));
        return convertView;
    }

    //添加一个元素
    public void add(DetailsSearchListItem data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    //批量添加元素
    public void add(List<DetailsSearchListItem> datas) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.clear();
        for(DetailsSearchListItem data : datas) {
            mData.add(data);
        }
        notifyDataSetChanged();
    }

    //往特定位置，添加一个元素
    public void add(int position, DetailsSearchListItem data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(position, data);
        notifyDataSetChanged();
    }

    public void remove(DetailsSearchListItem data) {
        if (mData != null) {
            mData.remove(data);
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (mData != null) {
            mData.remove(position);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if (mData != null) {
            mData.clear();
        }
        notifyDataSetChanged();
    }

    private class ViewHolder {
        TextView ds_transaction_type;
        TextView ds_transaction_money;
        TextView ds_transaction_time;
        TextView ds_left_money;
    }

}
