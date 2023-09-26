package com.gxa.boot338.common;

import lombok.Data;

import java.io.Serializable;

/*
* R:Result
* 作用：将返回给调用方法的数据进行规范
* code:响应状态
* msg:响应xinx
* data:响应数据
* */

@Data
public class R<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success(T data){
        R<T> r=new R<T>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    public static <T> R<T> failed(String msg){
        R<T> r=new R<T>();
        r.setCode(10009);
        r.setMsg(msg);
        return r;
    }
}
