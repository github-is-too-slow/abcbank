package com.billion.abcapp;

import java.sql.Timestamp;

public class DetailsSearchListItem {
    private String bankNum;
    private double transactionMoney;
    private Timestamp transactionTime;
    private String transactionComment;
    private String fromName;
    private String fromAccount;
    private String transactionType;
    private String transactionChannel;
    private double leftMoney;
    private String attachComment;

    public DetailsSearchListItem() {
    }

    public DetailsSearchListItem(String transactionComment, double transactionMoney,
                                 Timestamp transactionTime, double leftMoney) {
        this.transactionMoney = transactionMoney;
        this.transactionTime = transactionTime;
        this.transactionComment = transactionComment;
        this.leftMoney = leftMoney;
    }

    public DetailsSearchListItem(String bankNum, double transactionMoney,
                                 Timestamp transactionTime, String transactionComment,
                                 String fromName, String fromAccount,
                                 String transactionType, String transactionChannel,
                                 double leftMoney, String attachComment) {
        this.bankNum = bankNum;
        this.transactionMoney = transactionMoney;
        this.transactionTime = transactionTime;
        this.transactionComment = transactionComment;
        this.fromName = fromName;
        this.fromAccount = fromAccount;
        this.transactionType = transactionType;
        this.transactionChannel = transactionChannel;
        this.leftMoney = leftMoney;
        this.attachComment = attachComment;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public double getTransactionMoney() {
        return transactionMoney;
    }

    public void setTransactionMoney(double transactionMoney) {
        this.transactionMoney = transactionMoney;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionComment() {
        return transactionComment;
    }

    public void setTransactionComment(String transactionComment) {
        this.transactionComment = transactionComment;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionChannel() {
        return transactionChannel;
    }

    public void setTransactionChannel(String transactionChannel) {
        this.transactionChannel = transactionChannel;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }

    public String getAttachComment() {
        return attachComment;
    }

    public void setAttachComment(String attachComment) {
        this.attachComment = attachComment;
    }
}
