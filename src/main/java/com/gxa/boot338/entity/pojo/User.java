package com.gxa.boot338.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户信息的实体类型，对应tb_user表")
public class User implements Serializable {

    @ApiModelProperty(name = "user_id",value = "用户id",hidden = true)
    private Integer id;
    @ApiModelProperty(name = "username",value = "用户名",required = true,example = "gxa")
    private String username;
    private String nickName;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date regTime;



}
