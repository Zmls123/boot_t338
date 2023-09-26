package com.gxa.boot338.entity.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/*
* pojo：类型和数据表建立映射关系
* dto：数据传输对象，当我们调用接口时，封装传输的参数时使用
* */

@ApiModel("用户登录传输对象，包括用户名、密码两个特征")
@Data
public class UserDTO implements Serializable {

    @ApiModelProperty(name = "username",value = "用户名",required = true,example = "gxa")
    private String username;
    @ApiModelProperty(name = "password",value = "密码",required = true,example = "654321")
    private String password;



}
