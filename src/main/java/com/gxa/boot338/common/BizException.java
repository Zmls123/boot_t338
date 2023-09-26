package com.gxa.boot338.common;


import sun.reflect.annotation.ExceptionProxy;

/*
* 当前类专门标识业务类型
* */
public class BizException extends Exception {

    public BizException(String message){
        super(message);
    }

}
