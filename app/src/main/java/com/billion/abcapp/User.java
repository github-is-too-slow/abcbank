package com.billion.abcapp;

import java.sql.Timestamp;

public class User {
    private Long userId; // 对应mysql中的bigint
    private String userName; // varchar(20)
    private String phoneNum; // varchar(20)
    private String bankNum; // varchar(20)
    private int state;  // 状态0：未锁定，状态1：锁定，该字段用于扩展
    private String code; // 注册码，不与数据库字段对应

    public User() {
    }

    public User(Long userId, String userName, String phoneNum, String bankNum,
                int state, String code) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.bankNum = bankNum;
        this.state = state;
        this.code = code;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", bankNum='" + bankNum + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}
