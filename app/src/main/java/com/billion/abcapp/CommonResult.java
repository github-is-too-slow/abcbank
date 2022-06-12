package com.billion.abcapp;

public class CommonResult {
    // 0：未锁定
    // 1：已锁定
    // 2：注册信息为空
    // 3：注册码不存在
    private int code;
    private String comment;
    private Object data;

    public CommonResult() {
    }

    public CommonResult(int code, String comment) {
        this.code = code;
        this.comment = comment;
    }

    public CommonResult(int code, String comment, Object data) {
        this.code = code;
        this.comment = comment;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", comment='" + comment + '\'' +
                ", data=" + data +
                '}';
    }
}
