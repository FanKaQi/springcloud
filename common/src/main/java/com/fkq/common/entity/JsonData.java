package com.fkq.common.entity;

public class JsonData {

    private int code;
    private Object data;
    private String message;

    public JsonData() {
    }

    public JsonData(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static JsonData error(int code, String message) {
        return new JsonData(code, null, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
