package com.gxa.boot338.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/*
* 当控制器抛出异常时，会自动被全局异常处理器捕获，并同一进行处理
* */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /*
    * 根据异常的类型，执行不同的处理
    * 该方法只针对Exception类型的处理方法
    *
    *
    * 人为规定两种异常：
    * 业务异常
    * 系统异常：java自带的（空指针、数组下标越界），不返前端，返给前端系统开小差
    * */

    @ExceptionHandler(BizException.class)
    public R handlerException(BizException e){
        //返回标准的R给前端

        return R.failed(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R handlerException(Exception e){
        //以日志形式记录需要配置xml文件
        log.error(e.getMessage());
        return R.failed("系统开小差，请稍后再试");
    }
}
