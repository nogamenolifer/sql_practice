package com.example.util;

public class Res {
    private Object data;
    private Integer code;
    private String msg;

    public Res() {
    }

    public Res(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Res(Object data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Res(Object data, Integer code) {
        this.data = data;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Res{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
