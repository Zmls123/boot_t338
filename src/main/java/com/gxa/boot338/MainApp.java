package com.gxa.boot338;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.gxa.boot338.mapper")
public class MainApp {

    /*
    * 声明main方法启动boot程序
    * */
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);
    }
}
