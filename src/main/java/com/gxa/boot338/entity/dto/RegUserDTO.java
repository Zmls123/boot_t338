package com.gxa.boot338.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/*
* pojo：类型和数据表建立映射关系
* dto：数据传输对象，当我们调用接口时，封装传输的参数时使用
* */

@ApiModel("用户登录传输对象，包括用户名、密码两个特征")
@Data
public class RegUserDTO implements Serializable {

    @ApiModelProperty(name = "phone",value = "手机号",required = true)
    private String phone;
    @ApiModelProperty(name = "name",value = "密码",required = true,example = "654321")
    private String username;
    private String code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date regTime;


}
