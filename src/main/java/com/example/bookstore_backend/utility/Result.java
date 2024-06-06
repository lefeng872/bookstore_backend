package com.example.bookstore_backend.utility;

import org.springframework.data.relational.core.sql.In;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Result<T>{
    private String msg; // 错误信息
    private int code; // status code
    private T detail;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", detail=" + detail.toString() +
                '}';
    }
}
