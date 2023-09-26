package com.gxa.boot338.entity.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Empl implements Serializable {

    private Integer id;
    private String name;
    private String phone;
    private String pwd;


}
