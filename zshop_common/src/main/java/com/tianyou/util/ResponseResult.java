package com.tianyou.util;

import com.tianyou.constant.ResponseCodeConstant;

public class ResponseResult {

    public ResponseResult(){};

    public ResponseResult(int statuscode, String message, Object data) {
        this.statuscode = statuscode;
        this.message = message;
        this.data = data;
    }

    public static ResponseResult success(Object data){
        return new ResponseResult(ResponseCodeConstant.ResponseStautsSuccess,"success",data);
    }
    //响应状态码
    private int statuscode;

    //响应消息
    private String message;

    //响应数据
    private Object data;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
